class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        int m = maze[0].length;
        ArrayList<String> ans = new ArrayList<>();
        int[] dir = {1, 0, 0, -1};
        int[] dic = {0, -1, 1, 0};
        
        if(maze[0][0] == 0 || maze[n-1][m-1]==0){
            return ans;
        }
        
        char[] dirChars = {'D', 'L', 'R', 'U'};
        boolean[][] visited = new boolean[n][m];
        dfs(maze,0,0,n,m,dir,dic,dirChars,visited,"",ans);
        return ans;
    }
    
    
    void dfs(int[][] maze,int i,int j,int n,int m,int[] dr,int[] dc,char[] dirChars,boolean[][] visited,String path,ArrayList<String> ans){
        
        if(i == n-1 && j == m-1){
            ans.add(path);
            return;
        }
        
        visited[i][j] = true;
        
        for(int d = 0; d<4; d++){
            int newDir = i+dr[d];
            int newDic = j+dc[d];
            
            if(newDir >= 0 && newDic >= 0 && newDir < n && newDic < m && maze[newDir][newDic] == 1 && !visited[newDir][newDic]){
                dfs(maze,newDir,newDic,n,m,dr,dc,dirChars,visited,path+dirChars[d],ans);
            }
        }
        
        visited[i][j] = false;
    }
}