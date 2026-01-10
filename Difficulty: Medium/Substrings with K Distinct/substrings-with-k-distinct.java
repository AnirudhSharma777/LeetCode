class Solution {
    public int countSubstr(String s, int k) {
        //  code her
        return atMost(s,k) - atMost(s, k-1);
    }
    
    private int atMost(String s, int k){
        int l = 0,r = 0, n = s.length(), count = 0;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(; r < n; r++){
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            
            for(;hm.size() > k; l++){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l)) == 0){
                    hm.remove(s.charAt(l));
                }
            }
            
            count += r - l + 1;
        }
        
        return count;
    }
}