// using two pointer

class Solution {
    public int removeDuplicates(int[] nums) {
        
       int start = 0;
        int end = 0;
        for(start = 0; start < nums.length; start++){
            
            if(start < nums.length - 2 && nums[start] == nums[start+1] && nums[start] == nums[start+2]){
                continue;
            }
            else{
                nums[end] = nums[start];
                end++;
            }
        }
        return end;
    }
}