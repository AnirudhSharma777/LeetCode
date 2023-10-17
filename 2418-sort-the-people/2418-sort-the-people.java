class Pair{
    int height;
    String name;
    Pair(String name,int height){
        this.name = name;
        this.height = height;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair> list = new ArrayList<>();
        
        for(int i = 0; i<heights.length; i++){
            list.add(new Pair(names[i],heights[i]));
        }
        
        list.sort((a,b) -> {
            return b.height - a.height;
        });
        
        String[] str = new String[list.size()];
        for(int i = 0; i<list.size(); i++){
            str[i] = list.get(i).name;
        }
        return str;
    }
}