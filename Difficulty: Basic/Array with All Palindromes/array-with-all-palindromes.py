class Solution:
    def isPalinArray(self, arr):
        # code here
        isPalindrome = False
        for i in arr:
            reverse = self.helper(i)
            if reverse == i:
                isPalindrome = True
            else:
                isPalindrome = False
                break
        
        return isPalindrome
        
    
    def helper(self,n):
        res = 0
        while n > 0:
            rem = n % 10
            res = (res * 10) + rem
            n = n // 10
        
        return res