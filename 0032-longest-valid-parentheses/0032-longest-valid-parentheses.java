class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int cnt = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i<ch.length; i++){
            if(ch[i] == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    cnt = Math.max(cnt,i-st.peek());
                }
                else{
                    st.push(i);
                }
            }
            
        }
        return cnt;
    }
}