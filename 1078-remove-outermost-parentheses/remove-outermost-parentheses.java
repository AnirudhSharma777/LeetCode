class Solution {
    public String removeOuterParentheses(String s) {
        
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(st.size() > 0){
                    sb.append(s.charAt(i));
                }
                st.push(s.charAt(i));
            }
            else{
                st.pop();
                if(st.size() > 0){
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}