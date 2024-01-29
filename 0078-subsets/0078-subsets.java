class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,nums.length,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums,int index,int n,List<List<Integer>> ans,List<Integer> list){
        if(index == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[index]);
        helper(nums,index+1,n,ans,list);
        list.remove(list.size() - 1);
        helper(nums,index+1,n,ans,list);
    }
}
