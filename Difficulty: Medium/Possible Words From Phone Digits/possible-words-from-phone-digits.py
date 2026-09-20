class Solution:
    combinations:list[str] = ['','','abc','def','ghi','jkl','mno','pqrs','tuv','wxyz']
    def possibleWords(self, arr: list[int]) -> list[str]:
        # code here
        result: list[str] = []
        self.helper(arr,0,'',result)
        return result
    
    def helper(self,arr,i,ans,result):
        if i == len(arr):
            result.append(ans)
            return
        
        chars = self.combinations[arr[i]]
        
        if not chars:
            self.helper(arr, i + 1, ans, result)
            return

        for ch in chars:
            self.helper(arr, i + 1, ans + ch, result)
            
