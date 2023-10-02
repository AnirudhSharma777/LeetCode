class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> set = new HashSet<>();
       List<Integer> ans = new ArrayList<>();
        
        for(int i : nums1){
            set.add(i);
        }
        
        for(int i : nums2){
            if(set.contains(i)){
                ans.add(i);
                set.remove(i);
            }
        }
        
        int[] result = new int[ans.size()];
        int k = 0;
        for(int i : ans){
            result[k++] = i;
        }
        return result;        
    }
}