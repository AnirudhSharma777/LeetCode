class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;
        
        for(int i = 0; i<n; i++){
            if(i==0){
                left[0] = height[0];
                right[n-1] = height[n-1];
            }
            else{
                left[i] = Math.max(left[i-1],height[i]);
                right[n-i-1] = Math.max(right[n-i],height[n-i-1]);
            }
        }
        
        for(int i = 0; i<n; i++){
            water += Math.min(left[i],right[i]) - height[i];
        }
        return water;
        
    }

    
// Using Stack
 public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int water = 0;
        int cur = 0;
        
        while(cur < n){
            
            while(!st.isEmpty() && height[cur] > height[st.peek()]){
                int top = st.pop();
                if(st.isEmpty()){
                    break;
                }
                int d = cur-st.peek() - 1;
                int fill = d * (Math.min(height[cur],height[st.peek()]) - height[top]);
                water += fill;
            }
            st.push(cur++);
        }
        return water;
    }

    // Using Two Pointer
     public int trap(int[] height) {
        int n = height.length;
        int i = 0, j = n-1;
        int leftmax = 0;
        int rightmax = 0;
        int water = 0;
        
        
        while(i < j){
            if(height[i] <= height[j]){
                leftmax = Math.max(leftmax,height[i]);
                water += leftmax - height[i];
                i++;
            }
            else{
                rightmax = Math.max(rightmax,height[j]);
                water += rightmax - height[j];
                j--;
            }
        }
        return water;
    }
}
