class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i*i);
        }
        
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int a = arr[i] * arr[i];
                int b = arr[j] * arr[j];
                int c = a+b;
                if(set.contains(c)){
                    return true;
                }
            }
        }
        return false;
    }
}