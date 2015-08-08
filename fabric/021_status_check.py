from fabric.api import *

def host_type():
	run('uname -s')

def chkconfig_list():
	run('sudo chkconfig --list')
