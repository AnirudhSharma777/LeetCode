//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static String[] keywords =  {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        ArrayList<String> ans = new ArrayList<>();
        
        helper(a,N,0,ans,"");
        return ans;
    }
    
    static void helper(int[] a,int n,int index,ArrayList<String> res,String ans){
        
        if(index == n){
            res.add(ans);
            return;
        }
        
        int key = a[index];
        for(int i = 0; i<keywords[key].length(); i++){
            char ch = keywords[key].charAt(i);
            helper(a,n,index+1,res,ans+ch);
        }
    }
}


