class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,n,"",ans);
        return ans;        
    }
    
    public void helper(int openCnt,int closeCnt,String ans,List<String> temp){
        if(openCnt == 0 && closeCnt == 0){
            temp.add(ans);
            return;
        }
        
        if(openCnt > 0){
            helper(openCnt-1,closeCnt,ans+"(",temp);
        }
        if(closeCnt > 0){
            if(openCnt < closeCnt){
                helper(openCnt,closeCnt-1,ans+")",temp);
            }
        }
    }
}