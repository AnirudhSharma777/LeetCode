class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null && strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> hm = new HashMap<>();

        for(String str : strs){

            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if(!hm.containsKey(s)){
                hm.put(s,new ArrayList<>());
            }

            hm.get(s).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}