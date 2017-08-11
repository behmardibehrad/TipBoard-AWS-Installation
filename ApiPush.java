import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;




public class ApiPush {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		ApiPush http = new ApiPush();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://aws-public-ip:7272/";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		
		
		URL url1 = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)url1.openConnection(); 
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if(responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
		Scanner sc = new Scanner(url1.openStream());
		while(sc.hasNext())
		{
		line+=sc.nextLine();
		}
		System.out.println("\nJSON data in string format");
		System.out.println(line);
		sc.close();
			}
		

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "http://aws-public-ip:7272/api/v0.1/api-key/push";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("tile", "listing"));
		urlParameters.add(new BasicNameValuePair("key", "1"));

		ArrayList<String> list = new ArrayList<String>();
		list.add("test");
		list.add("test");
		list.add("test");
		list.add("test");
		
		String message;
		JSONObject json = new JSONObject();
		json.put("title", "test");
        json.put("items", list);
		message = json.toString();

		System.out.println(message);

		
		
		
		urlParameters.add(new BasicNameValuePair("data", message));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		
		

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " +
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}

}
