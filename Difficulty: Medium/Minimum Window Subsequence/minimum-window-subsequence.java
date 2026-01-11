class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        int i = 0, j = 0, k = 0;
        int n = s1.length();
        String str = "";
        int res = Integer.MAX_VALUE;
        
        for(; i<n; i++){
            if(s1.charAt(i) == s2.charAt(k)){
                k++;
            }
            
            if(k == s2.length()){
                j = i;
                k = s2.length() - 1;
                
                while(j >= 0 && k >= 0){
                    if(s1.charAt(j) == s2.charAt(k)){
                        k--;
                    }
                    j--;
                }
                
                j++;
                
                if(res > i-j+1){
                    res = i - j + 1;
                    str = s1.substring(j,i+1);
                }
                
                
                k=0;
                i = j+1;
                
            }
        }
        
        return str;
    }
}
