"""
n: int
return: list of int
"""
import math
        
class Solution:
    def jugglerSequence(self, n):
        # Code here
        result = []
        result.append(n)
        self.helper(n,result)
        return result
    
    def helper(self,n,result) -> None:
        if n <= 1:
            return
        
        if n % 2 == 0:
            n = math.floor(n ** 0.5)
        else:
            n = math.floor(n ** 1.5)
        
        result.append(n)
        
        return self.helper(n,result)