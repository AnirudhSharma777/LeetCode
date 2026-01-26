class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(arr,0,ans);
        return ans;
    }
    
    private static void helper(int[] arr,int index,ArrayList<ArrayList<Integer>> ans){
        
        if(index == arr.length){
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : arr){
                list.add(i);
            }
            ans.add(list);
            return;
        }
        
        
        for(int i = index; i<arr.length; i++){
            swap(arr,index, i);
            helper(arr,index+1,ans);
            swap(arr,index, i);
        }
    }
    
    
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
};