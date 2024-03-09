class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
            if(hm.get(i) > nums.length/2){
                return i;
            }
        }
        return -1;
    }
}