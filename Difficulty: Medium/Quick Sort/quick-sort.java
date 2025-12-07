class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low >)
            int partitionIndx = partition(arr,low,high);
            
            quickSort(arr,low,partitionIndx-1);
            quickSort(arr,partitionIndx+1,high);
      
    }

    private int partition(int[] arr, int low, int high) {
        
        // code here
        
        int pivot = arr[high];
        int i = low - 1;
        
        for(int j = low; j<=high-1; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
}