class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        helper(nums,n,0,0);
        return sum;
    }
    
    private void helper(int[] nums,int n,int index,int xor){
        if(index == n){
            sum += xor;
            return;
        }
        
        xor ^= nums[index];
        helper(nums,n,index+1,xor);
        xor ^= nums[index];
        helper(nums,n,index+1,xor);
        
    }
}