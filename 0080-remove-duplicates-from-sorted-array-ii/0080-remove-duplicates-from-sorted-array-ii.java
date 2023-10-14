// recursive Solution

class Solution {
    public int removeDuplicates(int[] nums) {
        return solve(0,0,0,nums.length,nums);
    }
    
    public int solve(int i,int j,int count,int n,int[] nums){
        if(i == n){
            return j;
        }
        
        if(i > 0 && nums[i] == nums[i-1]){
            count++;
        }
        else{
            count = 1;
        }
        
        if(count <= 2){
            nums[j++] = nums[i];
        }
        
        return solve(i+1,j,count,n,nums);
    }
}