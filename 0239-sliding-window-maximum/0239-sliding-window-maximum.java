class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) { // TC : O(n) + O(n) = O(n)
                                                       // SC : O(n)
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i<n; i++){
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[r++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}