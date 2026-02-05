class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int n = arr.length;
        int left = 0;
        int zeros = 0;
        int maxLen = 0;
        
        
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                zeros++;
            }
            
            while(zeros > k){
                if(arr[left] == 0){
                    zeros--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen,i - left + 1);
        }
        
        return maxLen;
    }
}