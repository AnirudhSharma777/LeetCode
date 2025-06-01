class Solution {
    public int countKDifference(int[] nums, int k) {
        
        int[] freq = new int[101+k];
        int n = nums.length;
        int pairs = 0;

        for(int i : nums){
            freq[i]++;
        }

        for(int i = 0; i<n; i++){
            pairs += freq[nums[i] + k];
        }

        return pairs;
    }
}