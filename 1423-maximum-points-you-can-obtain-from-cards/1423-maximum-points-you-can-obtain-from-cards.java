class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int curSum = 0;
        int max = 0;
        int n = cardPoints.length;
        
        for(int i = 0; i<k; i++){
            curSum += cardPoints[i];
        }
        max = Math.max(curSum,max);
        for(int i = k-1; i>=0; i--){
            curSum += cardPoints[n-k+i] - cardPoints[i];
            max = Math.max(max,curSum);
        }
        return max;
    }
}