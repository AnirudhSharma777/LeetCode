class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
     
        vector<vector<int>> ans(n,vector<int>(n,0));
        
        int left = 0,top = 0,right = n-1,bottom = n- 1;
        int size = n * n;
        int cnt = 1;
        
        while(cnt <= size){
            
            for(int i = left; i<=right && cnt<=size; i++){
                ans[top][i] = cnt;
                cnt++;
                
            }
            top++;
            
            for(int i = top; i<=bottom && cnt <= size; i++){
                ans[i][right] = cnt;
                cnt++;
            }
            right--;
            
            for(int i = right; i>=left && cnt<=size; i--){
                ans[bottom][i] = cnt;
                cnt++;
            }
            bottom--;
            
            for(int i = bottom; i>=top && cnt <=size; i--){
                ans[i][left] = cnt;
                cnt++;
            }
            left++;
        }
        return ans;
    }
};