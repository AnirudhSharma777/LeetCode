class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        int n = mat.length;
        int m = mat[0].length;
        int minDim = Math.min(n, m);
        
          long[][] pre = new long[n + 1][m + 1]; 

        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                pre[i][j] = mat[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }

        long target = x;
        int count = 0;

        
        for (int k = 1; k <= minDim; ++k) {
           
            for (int i = 1; i + k - 1 <= n; ++i) {
                int r = i + k - 1;
                for (int j = 1; j + k - 1 <= m; ++j) {
                    int c = j + k - 1;
                    long sum = pre[r][c] - pre[i - 1][c] - pre[r][j - 1] + pre[i - 1][j - 1];
                    if (sum == target) count++;
                }
            }
        }

        return count;
    }
}