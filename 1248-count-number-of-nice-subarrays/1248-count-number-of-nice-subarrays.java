class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        
        return helper(nums,k) - helper(nums,k-1);
    }
    
    private int helper(int[] arr,int k){
          int l = 0,r = 0,ans = 0,sum = 0,n = arr.length;

        for(;r<n;){
            sum += arr[r++];
            for(;sum > k && l<r;){
                sum -= arr[l++];
            }
            ans += r-l+1;
        }
        return ans;
    }
}