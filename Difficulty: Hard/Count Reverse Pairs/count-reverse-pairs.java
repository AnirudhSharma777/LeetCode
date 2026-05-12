class Solution {
    public int countRevPairs(int[] arr) {
        // code here
        int n = arr.length;
        return mergeSort(arr,0,n-1);
    }
    
    int mergeSort(int[] arr,int start,int end){
        if(start < end){
            int cnt = 0;
            int mid = start + (end - start)/2;
            cnt += mergeSort(arr,start,mid);
            cnt += mergeSort(arr,mid+1,end);
            cnt += countPairs(arr,start,mid,end);
            merge(arr,start,mid,end);
            return cnt;
        }
        
        return 0;
    }
    
    int countPairs(int[] arr,int start,int mid,int end){
        
        int cnt = 0;
        int j = mid+1;
        
        for(int i = start; i<=mid; i++){
            
            while(j<=end && arr[i] > 2*arr[j]){
                j++;
            }
            
            cnt += j-(mid + 1);
        }
        return cnt;
        
    }
    
    void merge(int[] arr,int start,int mid, int end){
        
        int[] temp = new int[(end-start)+1];
        int k = 0;
        int i = start;
        int j = mid + 1;
        
        while(i<=mid && j<=end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        
        while(j<=end){
            temp[k++] = arr[j++];
        }
        
        
        for(int a = 0; a<temp.length; a++){
            arr[start+a] = temp[a];
        }
    }
}