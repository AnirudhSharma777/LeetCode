class Solution {
    public void sort012(int[] arr) {
        // code here
        int n = arr.length;
        int zero = 0;
        int one = 0;
        
        int i = 0;
        while(i < n){
            if(arr[i] == 0){
                zero++;
            }
            else if(arr[i] == 1){
                one++;
            }
            i++;
        }
        
        for(i = 0; i<n; i++){
            if(zero-- > 0){
                arr[i] =0;
            }
            else if(one-- > 0){
                arr[i] = 1;
            }
            else{
                arr[i] = 2;
            }
        }
    }
}