from fabric.api import *

def host_type():
	run('uname -s')

def yum_update():
	run('sudo yum -y update')

def yum_install_apache():
	run('sudo yum -y install httpd')
