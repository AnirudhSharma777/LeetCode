// LET TRY BETTER THE BRUTE FORCE APPROACH

// In this approach i am using Extra space o(n+m);
// but the time complexity is O(n*m) which is better than brute force approach

// let optimize more neglet using  extra space 
//  means space complexity is O(1)


class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int m = matrix[0].size();
        
//         int row[n] = {0};  matrix[..][0]
//         int col[m] = {0};  matrix[0][..]
        
        int col0 = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                   
                    if(j != 0){
                         matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(matrix[i][j] != 0){
                    
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int j = 0; j<m; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(col0 == 0){
            for(int i = 0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
        

    }
};