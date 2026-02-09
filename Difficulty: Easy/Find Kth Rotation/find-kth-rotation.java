class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int low = 0, high = arr.length-1;
        
        if(arr[low] <= arr[high]){
            return 0;
        }
        
        
        while(low <= high){
            int mid = low + (high -low)/2;
            
            if(mid < high && arr[mid] > arr[mid+1]){
                return mid + 1;
            } 
            
            if(mid > low && arr[mid] < arr[mid - 1]){
                return mid;
            }
            
            
            if(arr[low] <= arr[mid]){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
            
        }
        
        return 0;
    }
}