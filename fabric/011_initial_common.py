from fabric.api import *

def host_type():
	run('uname -s')

def yum_update():
	run('sudo yum -y update')

def yum_install_munin_server():
	run('sudo yum -y --enablerepo=epel install munin')
	run('sudo yum -y --enablerepo=epel install munin-node')
	run('sudo yum -y install httpd')
	run('cat /etc/httpd/conf.d/munin.conf')
	run('sudo htpasswd -c /etc/munin/munin-htpasswd munin')
	run('sudo /etc/rc.d/init.d/httpd start')
	run('sudo chkconfig httpd on')
	run('sudo /etc/rc.d/init.d/munin-node start')
	run('sudo chkconfig munin-node on')
