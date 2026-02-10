class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int n = arr.length-1;
        int start = 1;
        int end = 0;
        int ans = -1;
        for(int i : arr){
            end = Math.max(i,end);
        }
        
        int mid = start + (end - start)/2;
        
        while(start<=end){
            if(check(arr,mid,k)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            
            mid = start + (end - start)/2;
        }
        
        return ans;
    }
    
   boolean check(int[] arr, int speed, int k) {
        long totalHours = 0; // Use long to prevent overflow
        for (int pile : arr) {
            // Calculate ceiling of (pile / speed)
            totalHours += (pile + speed - 1) / speed;
        }
        return totalHours <= k;
    }
    
}
