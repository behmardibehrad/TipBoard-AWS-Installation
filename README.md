# TipBoard-AWS-Installation

#### 1. Create an EC2 Instace on AWS. (Ubuntu 16.04)
##

#### 2. Download the ssh key <key-name.pem>
##

#### 3. Create an ssh directory if you dont have one:
	- mkdir ~/.ssh
##

#### 4. Copy the key to your ssh folder and set the permission:
	- cp ~/Download/<key-name.pem> ~/.ssh
	- chmod 400 <key-name.pem>
##

#### 5. Copy your Instance public IP, and connect:
	- ssh -i ~/.ssh/<key-name.pem> ubuntu@public IP
##

#### 6. Install virtual environment:
		- sudo apt-get install python-virtualenv
##

#### 7. Install redis-server:
		- sudo apt-get install redis-server
##		
		
#### 8. Install python development pachake:
    	- sudo apt-get install python-dev
##
				
#### 9. Create a new virtual environment:
    	- virtualenv <name_of_virtual-env>
##
		
#### 10. Activate the virtual environment:
    	- source <name_of_virtual-env>/bin/activate
##

#### 11. Install tipboard using pip:
		- pip install tipboard
##

#### 12. Confirm the installation: 	
		- tipboard runserver [<host>] [<port>]
##

#### 13. Create a new tipboard project:
		- tipboard create_project <name_of_project>
##

#### 14. Confirm the installation: 	
		- tipboard runserver 0.0.0.0 7272
##		

#### 15. Create inbound rule for Tipboard on your AWS instance:
		- HTTP      TCP     7272      0.0.0.0/0
##

#### 16. Point the web-browser to AWS_Public_ip:7272
		- you should see an empty dashboard
##

#### 17. To exit the enviroment use this command:
		- deactivate
		
### NOTES:
#### 1. If you have different versions of python installed:
		- tipboard works with python 2
		- create the virtualenv using 
			- virtualenv --python=/usr/bin/python2.7 <path/to/new/virtualenv/>
##
#### 2. Commands for redis-server
		- sudo /etc/init.d/redis-server restart
		- sudo /etc/init.d/redis-server start
		- sudo /etc/init.d/redis-server stop
##

#### 3. 