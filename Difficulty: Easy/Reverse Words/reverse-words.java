//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        // code here
                int i = S.length() - 1;
        int end = S.length();
        String result = "";
        while(i>=0){
            
            if(S.charAt(i) == '.'){
                result = result + S.substring(i+1,end)+".";
                end = i;
            }
            i--;
        }
        result += S.substring(i+1,end);
        
        return result;

    }
}