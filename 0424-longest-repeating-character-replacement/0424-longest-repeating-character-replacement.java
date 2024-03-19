class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0,r=0,n=s.length(),ans = 0;
        int cnt = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(;r<n; r++){
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            cnt = Math.max(cnt,hm.get(s.charAt(r)));
            for(;r-l+1-cnt > k && l<r; l++){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
            }
            
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}