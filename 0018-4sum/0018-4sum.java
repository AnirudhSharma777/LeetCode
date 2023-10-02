class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length - 3; i++){
            if(i == 0 ||(i>0 && nums[i] != nums[i-1])){
                for(int j = i+1; j<nums.length - 2; j++){
                    if(j == 1+i || (j > 1+i && nums[j] != nums[j-1])){
                        int start = j+1;
                        int end = nums.length - 1;
                        long sum = nums[i] + nums[j];
                        long rem = target - sum;
                        while(start < end){
                            if(nums[start] + nums[end]  == rem){
                                ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                                
                                while(start < end && nums[start] == nums[start+1]) start++;
                                while(start < end && nums[end] == nums[end - 1]) end--;
                                
                                start++;
                                end--;
                            }
                            else if(nums[start] + nums[end] < rem){
                                start++;
                            }
                            else{
                                end--;
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
        
    }
}