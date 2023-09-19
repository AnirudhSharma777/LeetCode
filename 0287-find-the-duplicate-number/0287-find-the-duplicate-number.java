class Solution {
    public int findDuplicate(int[] nums) {
         int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > 1){
                ans = e.getKey();
            }
        }
        return ans;
    }
}