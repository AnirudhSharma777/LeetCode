class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,0,target,res,new ArrayList<>());
        return res;
    }
    
    public void helper(int[] nums,int start,int target,List<List<Integer>> res,List<Integer> temp){
        if(target < 0){
            return;
        }
        
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i<nums.length; i++){
            if(i != start && nums[i] == nums[i-1]) continue;
            
            if(nums[i] > target){
                break;
            }
            
            temp.add(nums[i]);
            helper(nums,i+1,target-nums[i],res,temp);
            temp.remove(temp.size()-1);
        }
    }
}