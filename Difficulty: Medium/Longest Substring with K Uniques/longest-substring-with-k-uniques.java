class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int r = 0,l = 0,ans = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(;r<n;r++){
            char ch = s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            for(;hm.size() > k; l++){
                char c = s.charAt(l);
                hm.put(c,hm.getOrDefault(c,0)-1);
                if(hm.get(c) <= 0){
                    hm.remove(c);
                }
            }
            if(hm.size() == k){
                ans = Math.max(ans,(r-l+1));
            }
        }
        
        return ans;
    }
}