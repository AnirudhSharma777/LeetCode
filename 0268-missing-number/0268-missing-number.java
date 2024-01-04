class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // int totalSum = n * (n + 1) / 2;
        // int sum = 0;
        // for(int i:nums){
        //     sum += i;
        // }
        // return totalSum - sum;
        Arrays.sort(nums);
         int cnt = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == cnt){
                cnt++;
            }
        }
        return cnt;
    }
}