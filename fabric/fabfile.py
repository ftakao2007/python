from fabric.api import *

def host_type():
	run('uname -s')
