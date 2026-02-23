class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i : a){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int i : b){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int i : hm.keySet()){
            ans.add(i); // Add the key (the number), not the count
        }
        Collections.sort(ans); // You'll likely need this
        return ans;
    }
}