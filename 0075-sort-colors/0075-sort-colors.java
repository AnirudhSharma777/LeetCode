class Solution {
    public void sortColors(int[] nums) {
        
        int count_0 = 0;
        int count_1 = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                count_0++;
            }
            else if(nums[i] == 1){
                count_1++;
            }
        }
        
        for(int i = 0; i<nums.length; i++){
            if(i < count_0){
                nums[i] = 0;
            }
            else if(i>=count_0 && i < count_0+count_1){
                nums[i] = 1;
            }
            else{
                nums[i] = 2;
            }
        }
    }
}