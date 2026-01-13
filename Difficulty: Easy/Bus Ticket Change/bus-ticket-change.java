class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int n = arr.length;
        int cnt5 = 0, cnt10 = 0;
        
        for(int i = 0; i<n;i++){
            if(arr[i] == 5){
                cnt5++;
            }
            else if(arr[i] == 10){
                if(cnt5 < 1){
                    return false;
                }
                cnt5--;
                cnt10++;
            }else{
                if(cnt10 >= 1 && cnt5 >= 1){
                    cnt10--;
                    cnt5--;
                }
                else if(cnt5 >= 3){
                    cnt5 -= 3;
                }
                else{
                    return false;
                }
            }
        }
        
        return true;
    }
}