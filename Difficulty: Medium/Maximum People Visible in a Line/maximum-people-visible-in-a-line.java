class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n = arr.length;
        int[] nge = nge(arr);
        int[] pge = pge(arr);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(pge[i] == -1 && nge[i] == -1){
                max = Math.max(max, n);
            }else if(nge[i] != -1 && pge[i] != -1){
                max = Math.max(max, (nge[i] - pge[i] - 1));
            }else if(nge[i] == -1){
                max = Math.max(max, n - pge[i] - 1);
            }else{
                max = Math.max(max, nge[i]);
            }
        }
        return max;
        
    }
    private int[] nge(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            res[i] = -1;
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                res[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
    private int[] pge(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=arr.length-1; i>=0; i--){
            res[i] = -1;
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                res[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}