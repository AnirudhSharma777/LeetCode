class Solution {
    
    
    private int decodeHelper(String s,int n,int i,int[] dp){
        if(i >= n){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int singleDigit = decodeHelper(s,n,i+1,dp);
        int doubleDigit = 0;
        if(i+1 < n){
            int first = s.charAt(i) - '0';
            int second = s.charAt(i+1) - '0';
            int combo = first*10 + second;
            if(combo <= 26){
                doubleDigit = decodeHelper(s,n,i+2,dp);
            }
        }
        dp[i] = (singleDigit + doubleDigit);
        return dp[i];
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return decodeHelper(s,n,0,dp);
    }
    
    
}