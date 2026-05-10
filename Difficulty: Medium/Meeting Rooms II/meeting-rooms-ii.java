class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int n = start.length;
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int endpt = 0;
        int rooms = 0;
        
        for(int i = 0; i<n; i++){
            if(start[i] < end[endpt]){
                rooms++;
            }
            else{
                endpt++;
            }
        }
        
        return rooms;
    }
}
