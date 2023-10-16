class Solution {
    
    public int myAtoi(String s) {
        int total = 0;
        return ChangeStringToInteger(s,0,total,true,false);
    }
    
    public int ChangeStringToInteger(String s,int index,int total,boolean sign,boolean num){
        if(index == s.length()){
            return 0;
        }
        
        if(!num){
            
            if(s.charAt(index) == ' '){
                return ChangeStringToInteger(s,index+1,total,sign,num);
            }
            if(s.charAt(index) == '+' || s.charAt(index) == '-'){
                sign =  (s.charAt(index) == '-' ? false : true);
                return ChangeStringToInteger(s,index+1,total,sign,!num);
            }
        }
        
        num=true;
        char ch=s.charAt(index);
        if(ch-'0'<0 || ch-'0'>9) return 0;
        if(total>Integer.MAX_VALUE/10 || total==Integer.MAX_VALUE/10 && ch-'0'>7)
            return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
            
        total=total*10+ch-'0';
        int t=ChangeStringToInteger(s,index+1,total,sign,num);
        if(t==0) return sign?total:-total;
        else return t;
    }
}