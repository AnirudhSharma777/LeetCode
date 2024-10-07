class Solution {
    
    private int startMax;
    private int endMax;
    
    
    public String longestPalindrome(String s) {
        
        int n = s.length();
        
        if(n < 2){
            return s;
        }
        
        for(int i = 0; i<n; i++){
            checkIsPalindrome(s,i,i+1);
            checkIsPalindrome(s,i,i);
        }
        
        return s.substring(startMax,endMax+1);
    }
    
    private void checkIsPalindrome(String s,int start,int end){
        int len = s.length();
        while(start>=0 && end < len &&  s.charAt(start) == s.charAt(end)){
            int curlen = end - start + 1;
            int maxLen = endMax - startMax + 1;
            if(curlen > maxLen){
                endMax = end;
                startMax = start;
            }
            start--;
            end++;
        }
    }
}