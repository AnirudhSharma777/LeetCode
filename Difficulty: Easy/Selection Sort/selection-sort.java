class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        
        for(int i = 0; i<n; i++){
            int min = i;
            int j = i+1;
            while(j <= n-1){
                if(arr[j] < arr[min]){
                    min = j;
                }
                j++;
            }
            
            if(i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        
        
    }
}