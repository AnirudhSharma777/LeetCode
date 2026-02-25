class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int cnt = 0;
        int length = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        hm.put(0,-1);
        
        for(int i = 0; i<n; i++){
            if(arr[i] <= k){
                cnt--;
            }
            else{
                cnt++;
            }
            
            if(cnt > 0){
                length = Math.max(length,i+1);
            }
            if(hm.containsKey(cnt - 1)){
                length = Math.max(length,i-hm.get(cnt-1));
            }
            
            if(!hm.containsKey(cnt)){
                hm.put(cnt,i);
            }
        }
        return length;
    }
}