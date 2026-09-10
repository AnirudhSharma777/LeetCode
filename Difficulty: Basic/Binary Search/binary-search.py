class Solution:
    def binarySearch(self, arr, k):
        # code here
        return self.helper(arr,0,len(arr)-1,k)
    
    def helper(self,arr,start,end,target) -> bool:
        if start > end:
            return False
        
        mid = start + (end - start) // 2
        
        if arr[mid] == target:
            return True
        elif arr[mid] > target:
            return self.helper(arr,start,mid-1,target)
        else:
            return self.helper(arr,mid+1,end,target)