// TC : O(n)
// SC : O(n)


class Solution {
    public int scoreOfParentheses(String s) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] ch = s.toCharArray();
        for(int i = 0; i<ch.length; i++){
            if(ch[i] == '(') {
                stack.push(cnt);
                cnt = 0;
            }
            else{
                cnt = stack.peek() + Math.max(2*cnt,1);
                stack.pop();
            }
        }
        
        return cnt;
    }
}