class Solution {
    public boolean isPalindrome(String s) {
        
        String str = helper(s);
        System.out.println(str);
        int start = 0;
        int end = str.length()-1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;        
    }
    
    public String helper(String s){
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        
        for(int i = 0; i<s.length(); i++){
            int ascii = (int)s.charAt(i);
            if((ascii >= 97 && ascii <= 122) ||(ascii>=48 && ascii<=57)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}