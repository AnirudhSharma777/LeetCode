class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 0;
        int end = -1;
        for(int i : piles){
            end = Math.max(end,i);
        }
        int ans = -1;
        int mid = start + (end - start) / 2;
        // O(n * log(n))
        while(start <= end){
            if(isPossible(piles,mid,h)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }
    
    private boolean isPossible(int[] piles,int mid,int h){
        int times = 0;
        for(int i : piles){
            times += Math.ceil(i*1.0/mid);
        }
        return times <= h;
    }
}