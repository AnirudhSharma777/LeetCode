class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0,right = m-1,top = 0,bottom = n-1;
        List<Integer> list = new ArrayList<>();
        int size = n*m;
        int cnt = 0;
        while(cnt < size){
            for(int i = left; i<=right && cnt < size; i++){
                list.add(matrix[top][i]);
                cnt++;
            }
            top++;
            for(int i = top; i<=bottom && cnt < size; i++){
                list.add(matrix[i][right]);
                cnt++;
            }
            right--;
            for(int i = right; i>=left && cnt < size; i--){
                list.add(matrix[bottom][i]);
                cnt++;
            }
            bottom--;
            for(int i = bottom; i>=top && cnt < size; i--){
                list.add(matrix[i][left]);
                cnt++;
            }
            left++;
        }
        return list;
    }
}