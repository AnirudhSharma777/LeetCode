class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0){
            return s;
        }
        Stack<String> st = new Stack<>();
        String ans ="";
        for(int i = 0; i<s.length(); i++){
            
            String word = "";
            if(s.charAt(i) == ' ') continue;
            
            while(i<s.length() && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }
            st.push(word);
        }
        
        while(!st.isEmpty()){
            ans += st.pop();
            if(!st.isEmpty()){
                ans += ' ';
            }
        }
        return ans;
    }
}