class Solution {
    public int totalElements(int[] arr) {
        // code here
        
        int n = arr.length;
        int r = 0, l = 0, maxLen = Integer.MIN_VALUE;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(;r<n; r++){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            for(;hm.size() > 2; l++){
                hm.put(arr[l],hm.getOrDefault(arr[l],0)-1);
                if(hm.get(arr[l]) <= 0){
                    hm.remove(arr[l]);
                }
            }
            maxLen = Math.max(maxLen,(r-l+1));
        }
        
        return maxLen;
    }
}