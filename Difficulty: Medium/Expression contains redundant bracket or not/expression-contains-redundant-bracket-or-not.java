class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            }
            else if(ch == ')'){
                
                if(st.peek() == '('){
                    return true;
                }
                
                while(st.peek() != '('){
                    st.pop();
                }
                
                st.pop();
            }
        }
        
        
        return false;
    }
}
