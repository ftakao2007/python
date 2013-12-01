from fabric.api import *

def host_type():
	run('uname -s')

def yum_update():
	run('sudo yum -y update')

def yum_install_lib():
	run('sudo yum -y install gcc libstdc+-devel gcc-c+ fuse fuse-devel curl-devel libxml2-devel openssl-devel make mailcap')

def make_s3fs():
	#run("""
	#wget http://s3fs.googlecode.com/files/s3fs-1.62.tar.gz
	#tar zxvf s3fs-1.62.tar.gz 
	#cd s3fs-1.62
	#./configure --prefix=/usr
	#make
	#""")
	run('wget http://s3fs.googlecode.com/files/s3fs-1.62.tar.gz')
	#sudo('make install')

def yum_install_s3fs():
	yum_update()
	yum_install_lib()
	make_s3fs()
