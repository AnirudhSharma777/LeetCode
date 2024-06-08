class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};

        boolean[][] visited = new boolean[n][m];

        // traverse top row && last row
        for(int j = 0; j<m; j++){
            
            // top row
            if(!visited[0][j]  && board[0][j] == 'O'){
                dfs(0,j,n,m,drow,dcol,visited,board);
            }

            // last row
            if(!visited[n-1][j]  && board[n-1][j] == 'O'){
                dfs(n-1,j,n,m,drow,dcol,visited,board);
            }
        }

        // traverse top col && last col
        for(int i = 0; i<n; i++){

            // top col
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i,0,n,m,drow,dcol,visited,board);
            }

            // last col
            if(!visited[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,n,m,drow,dcol,visited,board);
            }
        }


        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i,int j,int n,int m,int[] drow,int[] dcol,boolean[][] visited,char[][] board){

        visited[i][j] = true;

        for(int k = 0; k < 4; k++){
            int nexti = i + drow[k];
            int nextj = j + dcol[k];

            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && !visited[nexti][nextj] && board[nexti][nextj] == 'O'){
                dfs(nexti,nextj,n,m,drow,dcol,visited,board);
            }
        }
    }
}