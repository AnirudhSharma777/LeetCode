class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int n = image.length;
        int m = image[0].length;
        int[] dr = {-1,0,0,1};
        int[] dc = {0,1,-1,0};
        
        boolean[][] visited = new boolean[n][m];
        
        int originalColor = image[sr][sc];
        if(originalColor == newColor){
            return image;
        }
        dfs(image,sr,sc,n,m,dr,dc,newColor,originalColor,visited);
        
        return image;
    }
    
    void dfs(int[][] image,int sr,int sc,int n,int m,int[] dr,int[] dc,int newColor,int originalColor,boolean[][] vis){
        
        if(sr>=n || sc >= m || sr < 0 || sc < 0 || vis[sr][sc] || image[sr][sc] != originalColor){
            return;
        }
        
        vis[sr][sc] = true;
        
        image[sr][sc] = newColor;
        
        for(int i = 0; i<4; i++){
            int newRow = sr+dr[i];
            int newCol = sc+dc[i];
            
            dfs(image,newRow,newCol,n,m,dr,dc,newColor,originalColor,vis);
        }
    }
}