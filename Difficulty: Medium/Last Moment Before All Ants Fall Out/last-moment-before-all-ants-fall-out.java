class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int maxLeft =  0;
        for(int i : left){
            maxLeft = Math.max(maxLeft,i);
        }
        
        int maxRight = 0;
        for(int i : right){
            maxRight = Math.max(maxRight, n-i);
        }
        
        return Math.max(maxLeft,maxRight);
    }
}