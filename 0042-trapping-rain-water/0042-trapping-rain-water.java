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
}