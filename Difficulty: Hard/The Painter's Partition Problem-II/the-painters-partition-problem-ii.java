class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int n = arr.length;
        int start = 0;
        int end = 0;
        for(int i : arr){
            end += i;
        }
        
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isPossible(arr,n,k,mid)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean isPossible(int[] arr,int n,int k,int mid){
        int paint = 1;
        int paintercnt = 0;
        
        for(int i = 0; i<n; i++){
            if(paintercnt+arr[i] <= mid){
                paintercnt += arr[i];
            }
            else{
                paint++;
                paintercnt = 0;
                if(paint > k || arr[i] > mid){
                    return false;
                }
                paintercnt = arr[i];
            }
        }
        
        return true;
    }
}
