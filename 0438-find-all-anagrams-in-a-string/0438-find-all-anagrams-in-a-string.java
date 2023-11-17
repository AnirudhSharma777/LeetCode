class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        if(s.length() == 0 || s == null) return ans;
        
        int[] charArray = new int[26];
        
        for(int i = 0; i<p.length(); i++){
            charArray[p.charAt(i)-'a']++;
        }
        
        // for(int i : charArray){
        //     System.out.print(i+" ");
        // }
        
        int l = 0,r = 0,k = p.length();
        for(;r<s.length(); ){
            if(charArray[s.charAt(r++) - 'a']-- >= 1){
                k--;
            }
            if(k == 0){
                ans.add(l);
            }
            if(r-l == p.length() && charArray[s.charAt(l++) -'a']++ >= 0){
                k++;
            }
        }
        
        return ans;
    }
}