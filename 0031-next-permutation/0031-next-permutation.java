class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null){
            return;
        }
        
        int index1 = -1;
        int index2 = -1;
        
        for(int i = nums.length - 2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index1 = i;
                break;
            }
        }
        
        if(index1 == -1){
            reverse(nums,0,nums.length-1);
        }
        else{
            for(int i = nums.length -1; i>=0; i--){
                if(nums[i] > nums[index1]){
                    index2 = i;
                    break;
                }
            }
            swap(nums,index1,index2);
            reverse(nums,index1+1,nums.length-1);
        }
    }
    
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i++,j--);
        }
    }
}