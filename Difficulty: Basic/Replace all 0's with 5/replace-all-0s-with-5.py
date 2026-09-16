class Solution:
    def convertFive(self, n):
        # code here
        if n == 0:
            return 5
        reverse = self.helper(n)
        return self.helper(reverse)
    
    
    def helper(self,n) -> int:
        res = 0
        while n > 0:
            N = n % 10
            if N == 0:
                N = 5
            res = (res * 10) + N
            n = n // 10
        
        return res