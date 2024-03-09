class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        helper(nums1,nums2,ans);
        int[] output = new int[ans.size()];
        int k = 0;
        for(int i : ans){
            output[k++] = i;
        }
        return output;
    }
    
    private void helper(int[] nums1,int[] nums2,ArrayList<Integer> ans){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums1){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int i : nums2){
            if(hm.containsKey(i)){
                int freq = hm.get(i);
                if(freq > 0){
                    ans.add(i);
                    hm.put(i,freq-1);
                }
            }
        }
    }
}