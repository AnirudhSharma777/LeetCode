class Solution {
    public String largestNumber(int[] nums) {
        
        String[] str = new String[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(str,(a,b)-> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        
        for(String it : str){
            sb.append(it);
        }
        
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}