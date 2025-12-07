class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        int n = arr.length;
        int i = 1;
        while(i < n){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            i++;
        }
    }
}