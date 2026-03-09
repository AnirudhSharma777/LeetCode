class Solution {
    public String largestSwap(String s) {
        // code here
        char[] ch = s.toCharArray();
        int n = ch.length;
        
        int maxIdx = n-1;
        int idx1 = -1;
        int idx2 = -1;
        
        for(int i = n-1; i>=0; i--){
            if(ch[i] > ch[maxIdx]){
                maxIdx = i;
            }
            else if(ch[i] < ch[maxIdx]){
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        
        
        if(idx1 != -1){
            char c = ch[idx1];
            ch[idx1] = ch[idx2];
            ch[idx2] = c;
        }
        
        return new String(ch);
        
    }
}