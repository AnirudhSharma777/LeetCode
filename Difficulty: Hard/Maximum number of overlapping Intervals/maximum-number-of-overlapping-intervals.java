
class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
        if(arr == null || arr.length == 0){
            return 0;
        }
        
        int n = arr.length;
        int ans = 0;
        
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<n; i++){
            int[] curr = arr[i];
            
            while(!pq.isEmpty() && pq.peek() < curr[0]){
                pq.poll();
            }
            
            pq.offer(curr[1]);
            
            ans = Math.max(ans,pq.size());
        }
        
        return ans;
    }
}
