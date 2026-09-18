class Solution {
    public static ArrayList<Integer> valEqualToPos(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<arr.length; i++){
            if(i+1 == arr[i]){
                list.add(arr[i]);
            }
            else{
                continue;
            }
        }
        
        return list;
    }
}
