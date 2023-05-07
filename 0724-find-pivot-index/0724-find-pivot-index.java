class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        
        int left_Sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum -= nums[i];
            
            if(left_Sum == sum){
                return i;
            }
            
            left_Sum += nums[i];
        }
        
        return -1;
    }
}