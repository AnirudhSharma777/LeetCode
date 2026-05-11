class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int idx = -1;
        
        for(int i = n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                idx = i;
                break;
            }
        }
        
        if(idx == -1){
            reverse(arr,0,n-1);
            return;
        }
        
        for(int i = n-1; i>idx; i--){
            if(arr[i] > arr[idx]){
                swap(arr,i,idx);
                break;
            }
        }
        
        reverse(arr,idx+1,n-1);
    }
    
    
     void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void reverse(int[] arr,int start,int end){
        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}