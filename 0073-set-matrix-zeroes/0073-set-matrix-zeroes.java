// LET TRY BETTER THE BRUTE FORCE APPROACH

// In this approach i am using Extra space o(n+m);
// but the time complexity is O(n*m) which is better than brute force approach



class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[] row = new int[n];
        int[] col = new int[m];
        
         for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        
        
        
    }
}