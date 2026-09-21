class Solution:
	def pushZerosToEnd(self, arr):
    	# code here
    	zeros = 0
    	idx = 0
    	for i in arr:
    	    if i != 0:
    	        arr[idx] = i
    	        idx += 1
    	
    	
    	while idx < len(arr):
    	    arr[idx] = 0
    	    idx += 1
    	
    	
    	return arr