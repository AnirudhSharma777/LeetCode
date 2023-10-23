class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int kth_value = 0;
        
        //O(n+m * logn(n))
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            // O(log(n+m))
            int count = getElementAllSmallest(matrix,mid,n);
            if(count >= k){
                kth_value = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return kth_value;
    }
    
    private int getElementAllSmallest(int[][] matrix,int mid,int n){
        
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row >=0 && col < n){
            if(matrix[row][col] <= mid){
                count += row+1;
                ++col;
            }
            else{
                --row;
            }
        }
        return count;
    }
}