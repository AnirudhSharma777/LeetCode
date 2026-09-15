class Solution:
    def permutation(self, s):
        # code here
        result = []
        s = list(s)
        self.helper(s,0,result)
        return sorted(result)
    
    def helper(self,s,idx,result):
        if idx == len(s):
            result.append("".join(s))
            return
        
        for i in range(idx, len(s)):
            s[i] , s[idx] = s[idx] , s[i]
            self.helper(s,idx+1,result)
            s[i] , s[idx] = s[idx] , s[i]