class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int m = newInterval.length;
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int[] i : intervals){
            arr.add(i);
        }
        
        arr.add(newInterval);
        
        Collections.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        
        int start = arr.get(0)[0];
        int end = arr.get(0)[1];
        
        
        for(int i = 1; i<arr.size(); i++){
            int s = arr.get(i)[0];
            int e = arr.get(i)[1];
            if(s>=start && s<=end){
                end = Math.max(end,e);
            }
            else{
                result.add(new int[]{start,end});
                start = s;
                end = e;
            }
        }
        
        result.add(new int[] {start,end});
        
        return result;
        
        
        
    }
}
