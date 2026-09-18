class Solution {
    // Method to find the element with odd occurrence in given array
    int getOddOccurrence(int[] arr) {
        // code here
        int result = 0;
        for(int i : arr){
            result ^= i;
        }
        
        return result;
    }
}