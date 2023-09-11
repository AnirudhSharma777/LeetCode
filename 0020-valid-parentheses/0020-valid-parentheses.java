class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'|| s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if(s.charAt(i) == ')' && top == '('){
                    continue;
                }
                if(s.charAt(i) == ']' && top == '[') {
                    continue;
                }
                if(s.charAt(i) == '}' && top == '{') {
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
}