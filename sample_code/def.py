#!/usr/bin/python
# coding: utf-8

def add(x, y):
     return x + y

print add(2, 3)

x = add(4, 5)
print x



i = int(raw_input('Enter number: '))

if i == 1:
     def foo(x, y):
         return x + y
else:
     def foo(x, y):
         return x - y

print foo(10, 5)
