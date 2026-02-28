class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        int i = arr1.length - 1;
        int j = 0;
        
        int minDiff = Integer.MAX_VALUE;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(i >= 0 && j < arr2.length){
            int sum = arr1[i] + arr2[j];
            
            int diff = Math.abs(sum-x);
            
            if(diff < minDiff){
                minDiff = diff;
                result = new ArrayList<>(Arrays.asList(arr1[i],arr2[j]));
            }
            
            if(sum == x){
                return result;
            }
            else if(sum < x){
                j++;
            }
            else{
                i--;
            }
        }
        
        return result;
    }
}