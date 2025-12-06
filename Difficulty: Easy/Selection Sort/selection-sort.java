class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        while(i < n){
            int min = i;
            int j = i+1;
            while(j<=n-1){
                if(arr[j] < arr[min]){
                    min = j;
                }
                j++;
            }
            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            i++;
        }
    }
}