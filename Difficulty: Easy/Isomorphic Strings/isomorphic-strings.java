class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        HashMap<Character,Character> hm = new HashMap<>();
        
        for(int i = 0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if(hm.containsKey(c1) && hm.get(c1) != c2){
                return false;
            }
            else if(hm.containsValue(c2) && !hm.containsKey(c1)){
                return false;
            }
            else{
                hm.put(c1,c2);
            }
        }
        
        return true;
    }
}