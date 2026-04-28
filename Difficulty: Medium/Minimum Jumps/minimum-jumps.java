class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        
        if(n <= 1) {
            return 0;
        }
        
        if(arr[0] == 0){
            return -1;
        }
        
        int jumps = 1;
        int steps = arr[0];
        int maxReach = arr[0];
        
        for(int i = 1; i<n-1; i++){
            
            maxReach = Math.max(maxReach,i+arr[i]);
            
            steps--;
            
            if(steps == 0){
                jumps++;
                
                if(i >= maxReach){
                    return -1;
                }
                
                steps = maxReach - i;
            }
        }
        
        return jumps;
    }
}