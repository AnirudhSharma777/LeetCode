class Solution:
    def isSubsetSum(self, arr: list[int], sum: int) -> bool:
        # code here
        n = len(arr)
        dp = [[-1] * (sum+1) for _ in range(n)]
        return self.helper(arr,0,sum,dp)
    
    def helper(self,arr,i,target,dp):
        if target == 0:
            return True
        
        if i == len(arr):
            return False
        
        if dp[i][target] != -1:
            return dp[i][target]
        
        exclude = self.helper(arr,i+1,target,dp)
        
        include = False
        if arr[i] <= target:
            include = self.helper(arr,i+1,target-arr[i],dp)
        
        dp[i][target] = exclude or include
        
        return dp[i][target]
        