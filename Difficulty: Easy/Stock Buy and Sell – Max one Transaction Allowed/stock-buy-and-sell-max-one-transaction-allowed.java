class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int n = prices.length;
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        
        while(right < n){
            if(prices[left] < prices[right]){
                maxProfit = Math.max(maxProfit,prices[right] - prices[left]);
            }
            else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}