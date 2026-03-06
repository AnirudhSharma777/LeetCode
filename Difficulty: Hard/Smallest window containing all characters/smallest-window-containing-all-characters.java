class Solution {
    public static String minWindow(String s, String p) {
        // code here
        if(s == null || p == null){
            return "";
        }
        
        int n = s.length();
        int m = p.length();
        
        if(m > n){
            return "";
        }
        
        int[] freq = new int[128];
        for(int i = 0; i<m; i++){
            freq[p.charAt(i)]++;
        }
        
        int have = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        
        for(int r = 0; r<n; r++){
            char ch = s.charAt(r);
            
            freq[ch]--;
            
            if(freq[ch] >= 0){
                have++;
            }
            
            
            while(have == m){
                int windowLen = r-left+1;
                if(windowLen < minLen){
                    minLen = windowLen;
                    minLeft = left;
                }
                
                char lc = s.charAt(left++);
                freq[lc]++;
                
                if(freq[lc] > 0){
                    have--;
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft,minLeft+minLen);
    }
}