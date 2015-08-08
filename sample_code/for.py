#!/usr/bin/python
# coding: utf-8

L = [ 'Toyota', 'Nissan', 'Honda' ] # リストを作成

for x in L :
	print x 

print '---------'

for x in L[1:] :
	print x

print '---------'

for x in range(3) :
	print x
else:
	print 'loop end'
print '---------'

y = range(0,10,3)
print y
