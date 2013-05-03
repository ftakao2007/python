class Person:
	def __init__(self, name, age):
		print '[Person.__init__]'
		self.name = name
		self.age = age
	def showinfo(self):
		print '[Person.showinfo]'
		print '%s (%d)' % (self.name, self.age)
