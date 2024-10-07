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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int startMax = 0;
    int endMax = 0;
    
    String longestPalindrome(String S){
        // code here
        int len = S.length();
        
        if(len < 2){
            return S;
        }
        
        for(int i = 0; i<len; i++){
            checkPalindrome(S,i,i+1);
            checkPalindrome(S,i,i);
        }
        
        return S.substring(startMax,endMax+1);
    }
    
    void checkPalindrome(String s,int start,int end){
        int len = s.length();
        
        while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
            int curlen = end - start + 1;
            int maxLen = endMax - startMax + 1;
            
            if(curlen > maxLen){
                startMax = start;
                endMax = end;
            }
            
            start--;
            end++;
        }
    }
}