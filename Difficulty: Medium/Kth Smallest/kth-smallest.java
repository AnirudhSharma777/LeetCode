class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<n; i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
