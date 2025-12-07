class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        while(i<n){
            int j = 0;
            while(j<n-i-1){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
            i++;
        }
    }
}