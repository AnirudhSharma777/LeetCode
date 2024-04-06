class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        
        for(int i = (2*n)-1; i>=0; i--){
            int cur = nums[i%n];
            while(!st.isEmpty() && st.peek() <= cur){
                st.pop();
            }
            if(!st.isEmpty()){
                nge[i%n] = st.peek();
            }else{
                nge[i%n] = -1;
            }
            st.push(cur);
        }
        return nge;
    }
}