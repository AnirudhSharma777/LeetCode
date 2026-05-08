class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        int n = arr.length;
        ArrayList<int[]> result = new ArrayList<>();
        
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
        
        for(int[] i : arr){
            int s = i[0];
            int e = i[1];
            if(s>=start && s<=end){
                end = Math.max(end,e);
            }
            else{
                result.add(new int[] {start,end});
                start = s;
                end = e;
            }
        }
        
        result.add(new int[] {start,end});
        
        return result;
    }
    
}