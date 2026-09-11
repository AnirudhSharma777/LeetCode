class Solution:
    def subsets(self, arr):
        # code here
        result = []
        n = len(arr)
        self.helper(arr,n,0,[],result)
        return result
    
    def helper(self,arr,n,i,ans,result) -> None:
        if i == n:
            result.append(ans.copy())
            return
        
        ans.append(arr[i])
        self.helper(arr,n,i+1,ans,result)
        ans.pop()
        self.helper(arr,n,i+1,ans,result)