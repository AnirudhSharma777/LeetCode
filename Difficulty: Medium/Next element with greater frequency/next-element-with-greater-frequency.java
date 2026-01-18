class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            ans.add(-1);
        }
        
        Stack<Integer> st = new Stack<>();
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        
        
        for(int i : arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int i = 0; i<arr.length; i++){
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && hm.get(arr[st.peek()]) < hm.get(arr[i])){
                    ans.set(st.pop(), arr[i]);
                }
                st.push(i);
            }
        }
        
        return ans;
    }
}