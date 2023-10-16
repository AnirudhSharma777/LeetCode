//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        int l = 0,r = 0,n = s.length(),ans = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(;r<n;r++){
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            for(;hm.get(s.charAt(r)) >= 2 && l < r; l++){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}