class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int n = arr.length;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0; i<k; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        result.add(hm.size());
        
        for(int i = k; i<n; i++){
            
            // remove the left element from hashmap
            int left = arr[i-k];
            hm.put(left,hm.get(left)-1);
            if(hm.get(left) == 0){
                hm.remove(left);
            }
            
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            
            result.add(hm.size());
        }
        
        return result;
    }
}