class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(nums1,nums2,ans);
        int[] result = new int[ans.size()];
        int k=0;
        for(int i : ans){
            result[k++] = i;
        }
        return result;
    }
    
    private void helper(int[] nums1,int[] nums2,ArrayList<Integer> list){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums1){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int i : nums2){
            if(hm.containsKey(i)){
                int freq = hm.get(i);
                if(freq > 0){
                    list.add(i);
                    hm.put(i,freq-1);
                }
            }
        }
    }
}