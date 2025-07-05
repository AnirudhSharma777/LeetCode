class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,n,ans,new ArrayList<>());
        return ans;
    }

    void helper(int[] nums,int index,int n,List<List<Integer>> ans,List<Integer> temp){
        if(index == n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        helper(nums,index+1,n,ans,temp);
        temp.remove(temp.size()-1);

        
        helper(nums,index+1,n,ans,temp);
    }
}