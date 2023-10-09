class Solution {
    public void reverseString(char[] s) {
        recur(s,0,s.length-1);
    }
    
    public static char[] recur(char[] s,int start,int end){
        
        // base case
        if(start > end){
            return s;
        }
                
        //swapping character at start with character at end 
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        //recursion call
        recur(s,start + 1,end - 1);
        
        return s;
    }
}