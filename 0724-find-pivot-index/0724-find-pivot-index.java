// Using prefix sum algorithm

class Solution {
    public int pivotIndex(int[] nums) {
        
        for(int i = 1; i<nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        
        if(nums[0] == nums[nums.length - 1]){
            return 0;
        }
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] == nums[nums.length - 1] - nums[i]){
                return i;
            }
        }
        
        return -1;
        
    }
}