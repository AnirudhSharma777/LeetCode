class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();
        
        for(int i : arr){
            if(!seen.add(i) && added.add(i)){
                list.add(i);
            }
        }
        
        return list;
    }
}