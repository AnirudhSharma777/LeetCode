class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0,r = 0, n = s.length(), ans = 0;
        
        HashMap<Character,Integer> m = new HashMap<>();
        
        for(;r<n; r++){
            m.put(s.charAt(r),m.getOrDefault(s.charAt(r),0)+1);
            for(;m.get(s.charAt(r)) > 1; l++){
               m.put(s.charAt(l),m.get(s.charAt(l))-1);
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}