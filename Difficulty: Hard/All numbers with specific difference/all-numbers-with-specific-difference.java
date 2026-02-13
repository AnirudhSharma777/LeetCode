class Solution {
    public int getCount(int n, int d) {
        // code here
        if(n<10) return 0;
        
        int i = 1, j=n,firstIdx = -1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(mid-sumOfDigit(mid) >= d){
                firstIdx = mid;
                j = mid - 1;
            }
            else if(mid-sumOfDigit(mid) < d){
                i = mid+1;
            }
        }
        if(firstIdx == -1){
            return 0;
        }
        return (n-firstIdx+1);
    }
    
    private int sumOfDigit(int n){
        int sum = 0;
        while(n > 0){
            sum += (n% 10);
            n /= 10;
        }
        return sum;
    }
}