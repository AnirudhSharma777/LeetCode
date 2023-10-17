//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        // code here
        int max = -1;
        
        for(int i = 0; i<arr.length(); i++){
            max = Math.max(arr.charAt(i)-'a',max);
        }
        
        int freq[] = new int[max+1];
        for(int i = 0; i<arr.length(); i++){
            freq[arr.charAt(i) - 'a']++;
        }
        
        for(int i = 1; i<freq.length; i++){
            freq[i] += freq[i-1];
        }
        
        char[] ch = new char[arr.length()];
        for(int i = arr.length()-1; i>=0; i--){
            ch[--freq[arr.charAt(i) - 'a']] = arr.charAt(i);
        }
        
        String str = new String(ch);
        return str;
    }
}