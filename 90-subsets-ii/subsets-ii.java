class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        helper(nums,0,n,ans,new ArrayList<>());
        return ans;
    }

    void helper(int[] nums,int index,int n,List<List<Integer>> ans,List<Integer> temp){
        ans.add(new ArrayList<>(temp));
       
       for(int i = index; i<n; i++){

            if(i != index && nums[i] == nums[i-1]){
                continue;
            }

            temp.add(nums[i]);

            helper(nums,i+1,n,ans,temp);

            temp.remove(temp.size()-1);
       }


    }
}