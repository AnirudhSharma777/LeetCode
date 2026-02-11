class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        
        int start = heights[0];
        int end = heights[0];
        long ans = Long.MAX_VALUE;
        for(int i : heights){
            end = Math.max(end,i);
            start = Math.min(start,i);
        }
        
        
        while(start <= end){
            int mid1 = start + (end - start)/3;
            int mid2 = end - (end - start)/3;
            
            long findCostLeftSide = findCost(heights,cost,mid1);
            long findCostRightSide = findCost(heights,cost,mid2);
            
            ans = Math.min(ans, Math.min(findCostLeftSide, findCostRightSide)); 
            
            if(findCostLeftSide < findCostRightSide){
                end = mid2 - 1;
            }
            else{
                start = mid1 + 1;
            }
        }
        
        return (int)ans;
    }
    
    private long findCost(int[] heights, int[] cost, int target) {
        long total = 0;

        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - target) * cost[i];
        }

        return total;
    }
}
