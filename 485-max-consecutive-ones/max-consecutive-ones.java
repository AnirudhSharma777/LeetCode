class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;

        int n = nums.length;

        for(int i= 0; i<n; i++){
            if(nums[i] == 1){
                cnt++;
            }
            else{
                cnt = 0;
            }
            max = Math.max(max,cnt);
        }

        return max;
    }
}