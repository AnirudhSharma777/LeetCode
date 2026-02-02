class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int total = 0, sum1 = 0, sum2 = 0;
        int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int i = 0; i<arr.length; i++){
            total += arr[i];
            
            sum1 += arr[i];
            
            sum2 += arr[i];
            
            min = Math.min(min,sum1);
            max = Math.max(max,sum2);
            
            if(sum1 > 0){
                sum1 = 0;
            }
            if(sum2 < 0){
                sum2 = 0;
            }
        }
        
        if(total == min){
            return max;
        }
        
        return Math.max(max,total-min);
    }
}
