class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MAX_VALUE;
        int max = 0;
        int sell = 0;
        for(int i = 0; i<prices.length; i++){
            if(prices[i] < maxProfit){
                maxProfit = prices[i];
            }
            sell = prices[i] - maxProfit;
            if(max < sell){
                max = sell;
            }
        }
        return max;
    }
}