class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int inicolor = image[sr][sc];
        int[][] ans = image;
        int[] drow = {-1,0,0,1};
        int[] dcol = {0,-1,1,0};

        dfs(sr,sc,ans,image,drow,dcol,inicolor,color);
        return ans;
    }

    private void dfs(int row,int col,int[][] ans,int[][] image,int[] drow,int[] dcol,int inicolor,int newcolor){
        
        ans[row][col] = newcolor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++){
            int nexti = row + drow[i];
            int nextj = col + dcol[i];

            if(nexti >= 0 && nextj >=0 && nexti < n && nextj < m && image[nexti][nextj] == inicolor && ans[nexti][nextj] != newcolor){
                dfs(nexti,nextj,ans,image,drow,dcol,inicolor,newcolor);
            }
        }
    }
}    
                