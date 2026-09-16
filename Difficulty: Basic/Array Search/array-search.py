class Solution:
    def search(self, arr, x):
        # code here
        for i in range(len(arr)):
            if arr[i] == x:
                return i
        
        return -1