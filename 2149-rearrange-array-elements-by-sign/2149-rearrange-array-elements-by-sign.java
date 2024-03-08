class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] > 0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        
        int i = 0,j = 0,k=0;
        while(i<pos.size() && j<neg.size()){
            if(k % 2 == 0){
                nums[k++] = pos.get(i++);
            }else{
                nums[k++] = neg.get(j++);
            }
        }
        
        while(i<pos.size()){
            nums[k++] = pos.get(i++);
        }
        
        while(j<neg.size()){
            nums[k++] = neg.get(j++);
        }
        
        return nums;
    }
}