class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int start = 0;
        int end = nums1.length;
        int combinelength = nums1.length + nums2.length;
        
        while(start <= end){
            int part1 = (start + end) / 2;
            int part2 =(combinelength + 1)/2 - part1;
            
            int left1 = getmax(nums1,part1);
            int right1 = getmin(nums1,part1);
            
            int left2 = getmax(nums2,part2);
            int right2 = getmin(nums2,part2);
            
            if(left1 <= right2 && left2 <= right1){
                if(combinelength % 2 == 0){
                    return (Math.max(left1,left2) + Math.min(right1,right2)) / 2.0;
                }else{
                    return (Math.max(left1,left2));
                }
            }
            else if(left1 > right2){
                end = part1 - 1;
            }
            else{
                start = part1 + 1;
            }
        }
        return -1;
    }
    
    public int getmax(int[] nums,int x){
        if(x == 0){
            return (int) Double.NEGATIVE_INFINITY;
        }
        else{
            return nums[x-1];
        }
    }
    public int getmin(int[] nums,int x){
        if(x==nums.length){
            return (int) Double.POSITIVE_INFINITY;
        }
        else{
            return nums[x];
        }
    }
}