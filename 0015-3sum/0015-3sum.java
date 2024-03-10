class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int start = i+1;
            int end = n-1;
            int sum = 0 - nums[i];
            while(start < end){
                if(nums[start] + nums[end] == sum){
                    list.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    
                    while(start < end && nums[start] == nums[start+1]){
                        start++;
                    }
                    
                    while(start < end && nums[end] == nums[end-1]){
                        end--;
                    }
                    
                    start++;
                    end--;
                }
                else if(nums[start] + nums[end] < sum){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return list;
    }
}