class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int i = 0,j = n-1, leftmax = 0,rightmax = 0;
        int water = 0;
        
        while(i < j){
            if(arr[i] <= arr[j]){
                leftmax = Math.max(leftmax,arr[i]);
                water += leftmax - arr[i];
                i++;
            }
            else{
                rightmax = Math.max(rightmax,arr[j]);
                water += rightmax - arr[j];
                j--;
            }
        }
        
        return water;
    }
}
