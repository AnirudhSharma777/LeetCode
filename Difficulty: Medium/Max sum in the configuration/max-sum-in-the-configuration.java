class Solution {
    int maxSum(int[] arr) {
        // code here
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int arrsum = 0;
        int curr = 0;
        for(int i = 0; i<n; i++){
            arrsum += arr[i];
            
            curr += i * arr[i];
        }
        
        max = curr;
        
        for(int i = 1; i<n; i++){
            curr = curr + arrsum - n * arr[n-i];
            max = Math.max(max,curr);
        }
        
        return max;
    }
}