class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return helper2(cost,n);
    }
    
    public int helper2(int[] cost,int n){
        int prev = cost[0];
        int prev1 = cost[1];
        for(int i = 2; i<n; i++){
            int cur = cost[i] + Math.min(prev,prev1);
            prev = prev1;
            prev1 = cur;
        }
        return Math.min(prev,prev1);
    }
}