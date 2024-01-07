class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<nums.length; i++){
            start = Math.max(nums[i],start);
            end += nums[i];
        }
        
        int mid = start + (end - start)/2;
        while(start <= end){
            if(helper(nums,mid,k)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            mid = start+(end-start)/2;
        }
        return ans;
    }
    
    private boolean helper(int[] nums,int mid,int m){
       int chunks = 0, i=0;
        while(i < nums.length){
            int val = 0;
            while(i < nums.length && nums[i] + val <= mid) val += nums[i++];
            chunks++;
        }
        return chunks <= m;
    }
}