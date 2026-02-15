// User function Template for Java



//User function Template for Java

class Solution
{
    public int findMinDiff (ArrayList<Integer> a, int m)
    {
        int n = a.size();
        if(n==0 || m==0){
            return 0;
        }
        
        if(n<m){
            return -1;
        }
        
        Collections.sort(a); //O(log n)
        Integer[] arr = a.toArray(new Integer[0]);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while(j < arr.length){
            if(j-i+1 == m){
                min = Math.min(min,arr[j]-arr[i]);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return min;
    }
}