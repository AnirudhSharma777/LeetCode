class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        helper(nums,ans);
        return ans;
    }
    
    void helper(int[] nums,List<Integer> list){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i : hm.keySet()){
            if(hm.get(i) > nums.length/3){
                list.add(i);
            }
        }
    }
}