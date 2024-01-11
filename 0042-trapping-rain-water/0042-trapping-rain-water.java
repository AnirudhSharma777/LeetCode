class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int n = height.length,ans = 0;
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && height[i] > height[st.peek()]){
                int cur = st.peek();
                st.pop();
                if(st.isEmpty()){
                    break;
                }
                int diff = i - st.peek() - 1;
                ans += (Math.min(height[st.peek()],height[i]) - height[cur])*diff;
            }
            st.push(i);
        }
        return ans;
    }
}