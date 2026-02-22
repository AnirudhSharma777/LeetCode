class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n = arr.length;
        int r = 0,xor=0,ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(;r<n; r++){
            xor ^= arr[r];
            
            if(xor == k){
                ans++;
            }
            
            int rem = xor ^ k;
            
            if(hm.containsKey(rem)){
                ans += hm.get(rem);
            }
            
            hm.put(xor,hm.getOrDefault(xor,0)+1);
        }
        
        return ans;
    }
}