class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int missing = -1;
        int repeating = -1;
        
        for(int i = 0; i<arr.length; i++){
            int num = Math.abs(arr[i]);
            int index = num - 1;
            
            if(arr[index] < 0) {
                repeating = num;
            }
            else{
                arr[index] = -arr[index];
            }
        }
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 0){
                missing = i+1;
                break;
            }
        }
        
        return new ArrayList<>(Arrays.asList(repeating, missing));
    }
}
