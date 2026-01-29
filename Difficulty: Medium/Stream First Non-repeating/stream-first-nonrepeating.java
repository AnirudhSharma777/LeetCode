class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            
            freq[ch - 'a']++;
            
            q.offer(ch);
            
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.poll();
            }
            
            if(q.isEmpty()){
                sb.append('#');
            }
            else{
                sb.append(q.peek());
            }
        }
        
        return sb.toString();
        
    }
}