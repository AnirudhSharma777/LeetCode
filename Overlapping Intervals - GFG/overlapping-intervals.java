//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        
        List<int[]> res = new ArrayList<>();
        
        if(Intervals.length == 0 || Intervals  == null){
            return res.toArray(new int[0][]);
        }
        
        Arrays.sort(Intervals,(a,b)->a[0]-b[0]);
        
        int start = Intervals[0][0];
        int end = Intervals[0][1];
        
        for(int[] i : Intervals){
            if(i[0] <= end){
                end = Math.max(end,i[1]);
            }
            else {
                res.add(new int[] {start,end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[] {start,end});
        return res.toArray(new int[0][]);
    }
}