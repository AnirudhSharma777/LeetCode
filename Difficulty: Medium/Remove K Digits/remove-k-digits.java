class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && ch < st.peek() && k > 0){
                st.pop();
                k--;
            }
            
            
            st.push(ch);
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        int startIndex = 0;
        while(startIndex < sb.length() && sb.charAt(startIndex) == '0'){
            startIndex++;
        }
        
        if(startIndex == sb.length()){
            return "0";
        }
        
        return sb.substring(startIndex);
        
    }
}