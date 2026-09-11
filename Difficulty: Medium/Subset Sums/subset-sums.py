class Solution:
	def subsetSums(self, arr):
		# code here
		n:int = len(arr)
		result=[]
		total = 0
		self.helper(arr,n,0,total,result)
		return result;
	
	def helper(self,arr,n,i,ans:int,result:list):
	    if(i == n):
	        result.append(ans)
	        return
	    ans += arr[i]
	    self.helper(arr,n,i+1,ans,result)
	    ans -= arr[i]
	    self.helper(arr,n,i+1,ans,result)
	    