class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = binarySearch(nums,target,true);
        if(firstOccurence == -1){
            return new int[] {-1,-1};
        }
        int secondOccurence = binarySearch(nums,target,false);
        return new int[] {firstOccurence,secondOccurence};
    }
    
    public int binarySearch(int[] nums,int target,boolean isTrue){
        
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        int mid = start + (end - start) / 2;
        while(start <= end){
            if(nums[mid] == target){
                ans = mid;
                if(!isTrue){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        
        return ans;
    }
}