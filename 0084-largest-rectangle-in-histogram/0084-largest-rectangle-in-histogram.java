class Solution {
    
    private int[] nextSmallestElement(int[] heights,int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = n-1; i>=0; i--){
            int cur = heights[i];
            while(st.peek() != -1 && heights[st.peek()] >= cur){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    
    private int[] prevSmallestElement(int[] heights,int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0; i<n; i++){
            int cur = heights[i];
            while(st.peek() != -1 && heights[st.peek()] >= cur){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int[] next = nextSmallestElement(heights,n);
        int[] prev = prevSmallestElement(heights,n);
        
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int l = heights[i];
            if(next[i] == -1){
                next[i] = n;
            }
            int b = next[i] - prev[i] - 1;
            int newAns = l*b;
            ans = Math.max(newAns,ans);
        }
        return ans;
    }
}