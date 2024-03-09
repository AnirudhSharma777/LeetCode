class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = null;
        for(int i = 0; i<numRows; i++){
            int j = 0;
            List<Integer> list = new ArrayList<>();
            while(j<=i){
                if(j==0 || j == i){
                    list.add(1);
                }
                else{
                    list.add(ans.get(j) + ans.get(j-1));
                }
                j++;
            }
            ans = list;
            result.add(list);
            
        }
        return result;
    }
}