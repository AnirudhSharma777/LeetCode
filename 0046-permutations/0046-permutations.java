class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    
    void helper(int[] nums,int startIndex,List<List<Integer>> ans){
        if(startIndex == nums.length-1){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<nums.length; j++){
                temp.add(nums[j]);
            }
            ans.add(temp);
            return;
        }
        else{
            for(int i = startIndex; i<nums.length; i++){
                swap(i,startIndex,nums);
                helper(nums,startIndex+1,ans);
                swap(i,startIndex,nums);
            }
        }
    }
    
    void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}