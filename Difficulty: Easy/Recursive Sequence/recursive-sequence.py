class Solution:
    MOD = 1000000007
    def sequence(self, n: int) -> int:
        # code here
        if n <= 0:
            return 0
        startPoint = self.start(n)
        currentTerm = self.helper(startPoint,n)
        return (self.sequence(n-1) + currentTerm) % self.MOD
    
    def start(self ,n:int) -> int:
        if n == 1:
            return 1
        return self.start(n-1) + (n-1)
    
    def helper(self, n:int,cnt:int) -> int:
        if cnt == 0:
            return 1
        return (n * self.helper(n+1,cnt-1)) % self.MOD