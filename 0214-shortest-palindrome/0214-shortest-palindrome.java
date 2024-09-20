class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n=s.length();
        for(int i=0;i<s.length();i++){
            if(s.substring(0, n - i).equals(rev.substring(i))){
                return rev.substring(0,i)+s;
            }
        }
        return rev+s;
    }
}