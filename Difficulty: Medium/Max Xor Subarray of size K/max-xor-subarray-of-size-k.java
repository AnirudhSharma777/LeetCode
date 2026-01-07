class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        
        int r = 0,l = 0,xor = 0,n=arr.length;
        int max = 0;
        
        for(;r<n; r++){
            xor ^= arr[r];
           
            if(r-l+1 > k){
                xor ^= arr[l];
                l++;
            }
            
            if(r-l+1 == k){
                max = Math.max(xor,max);
            }
            
        }
        return max;
    }
}
