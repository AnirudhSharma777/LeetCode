// let try brute force first 

// TC : O(n^3) 

class Solution {
public:
    
    
    void mark_Row(vector<vector<int>>& matrix, int n,int m,int i){
        
        for(int j = 0; j<m; j++){
            if(matrix[i][j] != 0){
                matrix[i][j] = INT_MIN+1 ;
            }
        }
    }
    
    void mark_col(vector<vector<int>>& matrix,int n, int m, int j){
        
        for(int i = 0; i<n; i++){
            if(matrix[i][j] != 0){
                matrix[i][j] = INT_MIN+1;
            }
        }
    }
    void setZeroes(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int m = matrix[0].size();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0){
                    mark_Row(matrix,n,m,i);
                    mark_col(matrix,n,m,j);
                }
            }
        }
        
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == INT_MIN+1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
};