class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0,n = s.length(),ans = 0;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(;r<n;r++){
            char ch = s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.getOrDefault('a',0) > 0 && hm.getOrDefault('b',0) > 0 && hm.getOrDefault('c',0) > 0){
                ans += (n-r);
                char c = s.charAt(l++);
                hm.put(c,hm.get(c)-1);
            }
        }
        return ans;
    }
}