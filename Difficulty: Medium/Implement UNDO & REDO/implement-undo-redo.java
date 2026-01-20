class Solution {
    
    private StringBuilder sb;
    private Stack<Character> st;
    
    public Solution(){
        sb = new StringBuilder();
        st = new Stack<>();
    }
    public void append(char x) {
        // append x into document
        sb.append(x);
        st.clear();
    }

    public void undo() {
        // undo last change
        if(sb.length() > 0){
            char ch = sb.charAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            st.push(ch);
        }
    }

    public void redo() {
        // redo changes
        if(!st.isEmpty()){
            sb.append(st.pop());
        }
    }

    public String read() {
        // read the document
        return sb.toString();
    }
}
