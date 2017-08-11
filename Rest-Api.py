
import requests
import json
import datetime

now = datetime.datetime.now()
now.strftime("%I:%M%p on %B %d, %Y")

url = 'http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push'






data_push_group_memebrs = dict(tile='listing',
                     key='1',
                     data=json.dumps({
                         "title": "Group Memebers",
                         "items": [["\t\tCS 101 GROUP PROJECT"],["1. Joshua Lilly"],["2. Behrddddddad Beddddddhmardi"],["3. William Zheng"],["4. Omnia Elemary"]]}))

r = requests.post(url, data=data_push_group_memebrs)


print(r.status_code, r.reason)
print(r.text)
print(r.status_code, r.reason)










