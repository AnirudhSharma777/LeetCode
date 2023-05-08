class Solution {
public:
    
    long long int binarySearch(int n){
        
        int start = 0;
        int end = n;
        
        long long int result = 0;
        
        long long int mid = start + (end - start) / 2;
        
        while(start <= end){
            
            long long int ans = mid * mid;
            
            if(ans == n){
                return mid;
            }
            else if(ans < n){
                result = mid;
                start = mid + 1;
            }
            else if(ans > n){
                end = mid - 1;
            }
            
            mid  = start + (end - start) / 2;
        }
        return result;
    }
    
    
    int mySqrt(int x) {
        
        if(x == 0 || x == 1){
            return x;
        }
        
        return binarySearch(x);
        
    }
};