class Solution:
    def permuteDist(self, arr):
        # code here
        n = len(arr)
        result = []
        self.helper(arr,0,result)
        return sorted(result)
    
    def helper(self,arr,idx,result) -> None:
        if idx == len(arr):
            result.append(arr.copy())
            return
        
        for i in range(idx,len(arr)):
            arr[i],arr[idx] = arr[idx],arr[i]
            self.helper(arr,idx+1,result)
            arr[i],arr[idx] = arr[idx],arr[i]
        