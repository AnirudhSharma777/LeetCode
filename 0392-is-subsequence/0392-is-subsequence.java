class Solution {
    public boolean isSubsequence(String s, String t) {
        int ans = solve(0,0,s,t);
        return ans == s.length();
    }
    
    public int solve(int i,int j,String s,String t){
        if(i == s.length() || j == t.length()){
            return 0;
        }
        
        if(s.charAt(i) == t.charAt(j)){
            return 1 + solve(i+1,j+1,s,t);
        }
        else{
            return solve(i,j+1,s,t);
        }
    }
}