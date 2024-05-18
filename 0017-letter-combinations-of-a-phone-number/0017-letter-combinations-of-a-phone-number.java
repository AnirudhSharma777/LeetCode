class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> hm = fromMap();
        List<String> res = new ArrayList<>();
        if(digits.length() > 0){
            helper(digits,0,hm,"",res);
        }
        return res;
    }
    
    private Map<Character,String> fromMap(){
        Map<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        
        return hm;
    }
    
    public void helper(String digits,int idx,Map<Character,String> hm,String ans,List<String> temp){
        
        if(idx == digits.length()){
            temp.add(ans);
            return;
        }
        
        String code = hm.get(digits.charAt(idx));
        
        for(int i = 0; i<code.length(); i++){
            helper(digits,idx+1,hm,ans+code.charAt(i),temp);
        }
    }
    
    
}