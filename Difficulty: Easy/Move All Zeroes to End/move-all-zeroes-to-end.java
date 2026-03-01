class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        int k = 0;
        while(i < n){
            if(arr[i] != 0){
                arr[k++] = arr[i];
            }
            i++;
        }
        
        while(k<n){
            arr[k++] = 0;
        }
        
    }
}