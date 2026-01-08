class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
       return atMost(arr,k) - atMost(arr,k-1);
    }
    
    public int atMost(int[] arr,int k){
         int r = 0, l = 0;
        int n = arr.length;
        int oddCount = 0;
        int count = 0;
        
        for(;r<n; r++){
            
            if(arr[r] % 2 != 0){
                oddCount++;
            }
            
            while(oddCount > k){
                if(arr[l] % 2 != 0){
                    oddCount--;
                }
                l++;
            }
            
            count += r-l+1;
        }
        
        
        return count;
    }
}
