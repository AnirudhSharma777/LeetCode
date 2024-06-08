//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                ArrayList<String> vec = new ArrayList<>();
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(i,j,visited,drow,dcol,vec,grid,i,j);
                    set.add(vec);
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int row,int col,boolean[][] visited,int[] drow,int[] dcol,ArrayList<String> ans,int[][] grid,int row0,int col0){
        
        visited[row][col] = true;
        ans.add(toString((row-row0), (col-col0)));
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            
            if(nrow >= 0 && ncol>=0 && nrow < n && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,visited,drow,dcol,ans,grid,row0,col0);
            }
            
        }
        
    }
    
    private String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
}
