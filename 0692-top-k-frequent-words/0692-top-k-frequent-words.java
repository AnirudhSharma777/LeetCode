class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        for(String word : words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        
        List<Map.Entry<String,Integer>> list = new LinkedList<>();
        for(Map.Entry<String,Integer> e : hm.entrySet()){
            list.add(e);
        }
        
        Collections.sort(list,new CustomComparator());
        
        List<String> ans = new ArrayList<>();
        
        for(int i = 0; i<k; i++){
            ans.add(list.get(i).getKey());
        }
        
        return ans;
    }
}

class CustomComparator implements Comparator<Map.Entry<String,Integer>>{
    @Override
    public int compare(Map.Entry<String,Integer> a ,Map.Entry<String,Integer> b){
        String s1 = a.getKey();
        int v1 = a.getValue();
        String s2 = b.getKey();
        int v2 = b.getValue();
        if(v1 != v2){
            return v2 - v1;
        }
        else return s1.compareTo(s2);
    }
}