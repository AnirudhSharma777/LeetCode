class Solution {
    public int maxProfit(int arr[], int k) {
        // Code here
           int profit=0,fee=arr[0];

        for(int i=1;i<arr.length;i++){

            profit=Math.max(profit,(arr[i]-fee-k));

            fee=Math.min(fee,arr[i]-profit);

        }

        return profit;
    }
}