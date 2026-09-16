class Solution:
	def countOddEven(self, arr):
		#Code here
		result = []
		odd = 0
		even = 0
		
		for i in arr:
		    if i % 2 == 0:
		        even += 1
		    else:
		        odd += 1
		 
		result.append(odd)
		result.append(even)
		 
		return result