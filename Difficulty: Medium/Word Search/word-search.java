class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == word.charAt(0)){
                    if(helper(mat,i,j,0,word)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    private boolean helper(char[][] mat,int i,int j,int idx,String word){
        
        if(idx == word.length()){
            return true;
        }
        
        if(i<0||j<0 || i >= mat.length || j>=mat[0].length || mat[i][j] != word.charAt(idx)){
            return false;
        }
        
        char temp = mat[i][j];
        mat[i][j] ='*';
        
        boolean found = helper(mat,i+1,j,idx+1,word)
        || helper(mat,i-1,j,idx+1,word) 
        || helper(mat,i,j+1,idx+1,word) 
        || helper(mat,i,j-1,idx+1,word);
        
        mat[i][j] = temp;
        return found;
    }
}