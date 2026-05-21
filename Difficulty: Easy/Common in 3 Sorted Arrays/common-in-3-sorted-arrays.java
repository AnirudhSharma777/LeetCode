class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        
        for(int i : a){
            set1.add(i);
        }
        
        for(int i : b){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        
        for(int i : c){
            if(set2.contains(i)){
                set3.add(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>(set3);
        Collections.sort(ans);
        return ans;
        
    }
}