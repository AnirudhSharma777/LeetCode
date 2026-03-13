class Solution {
    public boolean isvalid(String s){
       if(s.length()==0 || s.length()>3){
           return false;
       }
       
       int n=Integer.valueOf(s);
       if(s.length()>1 && s.charAt(0)=='0'){
           return false;
       }
       return n<=255;
   }
    public ArrayList<String> generateIp(String s) {
        // code here
        ArrayList<String> list = new ArrayList<>();
         int n=s.length();
       if(n<4){
           list.add("-1");
           return list;
       }
       
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               for(int k=j+1;k<n;k++){
                   String q1=s.substring(0,i);
                   String q2=s.substring(i,j);
                   String q3=s.substring(j,k);
                   String q4=s.substring(k);
                   if(isvalid(q1) && isvalid(q2) && isvalid(q3) && isvalid(q4)){
                       list.add(q1+"."+q2+"."+q3+"."+q4);
                   }
               } 
           }
       }
       if(list.size()==0){
           list.add("-1");
           return list;
       }
       return list;
    }
}