class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            arr.add(q.remove());
        }
        
        int n = arr.size();
        int i = 0, j = n/2, k = 0;
        
        while(n--> 0){
            if(k % 2 == 0){
                q.add(arr.get(i++));
            }
            else{
                q.add(arr.get(j++));
            }
            k++;
        }
    }
}
