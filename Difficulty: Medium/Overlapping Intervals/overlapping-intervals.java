class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]> result = new ArrayList<>();
        int n = arr.length;
        
        Arrays.sort(arr,(a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
            }
        });
        
        int start = arr[0][0];
        int end = arr[0][1];
        
        for(int i = 1; i<n; i++){
            int val1 = arr[i][0];
            int val2 = arr[i][1];
            
            if(val1 <= end){
                end = Math.max(end,val2);
            }else{
                result.add(new int[] {start,end});
                start = val1;
                end = val2;
            }
        }
        
        result.add(new int[]{start,end});
        
        return result;
    }
}