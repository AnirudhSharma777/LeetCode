//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        return helper(A,0,N-1) == true ? 1 : 0;
    }
    
    static boolean helper(int[] nums,int idx,int n){
        if(idx == n){
            return true;
        }
        
        if(nums[idx] == 0){
            return false;
        }
        
        for(int pos = 1; pos<=nums[idx]; pos++){
            if(helper(nums,idx+pos,n) == true){
                return true;
            }
        }
        
        return false;
    }
};