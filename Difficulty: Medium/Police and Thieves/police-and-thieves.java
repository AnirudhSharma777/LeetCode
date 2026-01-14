class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int cnt = 0;
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(arr[i] == 'P'){
                police.add(i);
            }
            else{
                thief.add(i);
            }
        }
        
        
        int i = 0;
        int j = 0;
        
        while(i<police.size() && j<thief.size()){
            int distance = Math.abs(police.get(i)-thief.get(j));
            
            if(distance <= k){
                i++;
                j++;
                cnt++;
            }
            else if(police.get(i) < thief.get(j)){
                i++;
            }
            else{
                j++;
            }
        }
        
        
        return cnt;
    }
}