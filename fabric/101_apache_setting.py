from fabric.api import *

def host_type():
	run('uname -s')

def yum_update():
	run('sudo yum -y update')

def yum_install_apache():
	run('sudo yum -y install httpd')

def apache_status():
	run('sudo /etc/rc.d/init.d/httpd status')

def apache_start():
	run('sudo /etc/rc.d/init.d/httpd start')

def apache_stop():
	run('sudo /etc/rc.d/init.d/httpd stop')

def apache_restart():
	run('sudo /etc/rc.d/init.d/httpd restart')

def apache_reload():
	run('sudo /etc/rc.d/init.d/httpd reload')

def apache_chkconfig_list():
	run('sudo chkconfig --list httpd')

def apache_chkconfig_on():
	run('sudo chkconfig httpd on')
	run('sudo chkconfig --list httpd')

def apache_chkconfig_off():
	run('sudo chkconfig httpd off')
	run('sudo chkconfig --list httpd')

# sudo /etc/rc.d/init.d/httpd
# Usage: httpd {start|stop|restart|condrestart|try-restart|force-reload|reload|status|fullstatus|graceful|help|configtest}
