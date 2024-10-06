class Solution {
    public String longestCommonPrefix(String[] strs) {
          
         
        if(strs.length == 0 || strs == null){
            return "";
        }
        int n = strs.length;
        String max = strs[0];
        String min = strs[0];
        
        for(int i = 1; i<n; i++){
            
            if(max.compareTo(strs[i]) > 0){
                max = strs[i];
            }
            
            if(min.compareTo(strs[i]) < 0){
                min = strs[i];
            }
        }
        
        int i = 0;
        int len = Math.min(max.length(),min.length());
        while(i < len){
            if(max.charAt(i) == min.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        
        return max.substring(0,i);
        
    }
}