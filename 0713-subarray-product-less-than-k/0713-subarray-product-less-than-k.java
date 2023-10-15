class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int r = 0,l = 0,n= nums.length ,ans = 0;
        
        for(;r<n; r++){
            product *= nums[r];
            for(;product >= k && l<=r ;l++) product /= nums[l];
            int len = (r-l+1);
            ans += len;
        }
        return ans;
    }
}