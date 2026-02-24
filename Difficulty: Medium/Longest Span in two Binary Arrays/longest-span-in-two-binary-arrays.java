class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        int sum = 0, ans = 0;
        
        for(int i = 0; i<a1.length; i++){
            sum +=(a1[i] - a2[i]);
            hm.put(sum,hm.getOrDefault(sum,i));
            ans = Math.max(ans,i-hm.get(sum));
        }
        
        return ans;
    }
}