class Solution:
    def countFriendsPairings(self, n: int) -> int:
        # code here 
        if n <= 1:
            return 1
        
        return self.countFriendsPairings(n-1) + (n-1) * self.countFriendsPairings(n-2)