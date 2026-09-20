class Solution:
    def  towerOfHanoi(self, n, fromm, to, aux):
        # code here
        return self.helper(n,fromm,aux,to)
    
    def helper(self,n,source,helper,destination) -> int:
        if n == 1:
            return 1
        
        move = self.helper(n-1,source,destination,helper)
        
        move += 1
        
        move += self.helper(n-1,helper,source,destination)
        
        return move