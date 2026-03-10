class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        
        for(int i = n-1; i>=0; i--){
            
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            
            st.push(i);
        }
        
        int count = 0;
        for(int i = 0; i<n; i++){
            count += nse[i] - i;
        }
        
        return count;
    }
}
