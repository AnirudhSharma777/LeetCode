class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[nums.length];
        int j = 0;
        for(int i = 0; i<nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() < k){
                arr[j++] = -1;
            }
            else{
                if(pq.size() > k){
                    pq.poll();
                }
                arr[j++] = pq.peek();
            }
        }
        return arr[arr.length -1];
    }
}