#!/usr/bin/python
# coding: utf-8

# http://python.keicode.com/lang/functions-lambda.php

f = lambda x, y: x + y
print f(1, 2)


a = [ lambda x, y: x + y, lambda n, m: n * m ]
for f in a:
     print f(10, 5)
