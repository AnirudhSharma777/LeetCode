class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        int j = 0;
        for(i = 0;i<nums.length; i++){
            
            if(i < nums.length - 2 && nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                continue;
            }
            else{
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}