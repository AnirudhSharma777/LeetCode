//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
      
        ArrayList<Integer> list = new ArrayList<>(hm.keySet());
        
        Collections.sort(list,(a,b) -> {
           return  (hm.get(a) == hm.get(b)) ? a - b : hm.get(b) - hm.get(a);
        });
        
        // System.out.print(list);
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int num : list) {
            for (int j = 0; j < hm.get(num); j++) {
                ans.add(num);
            }
        }
        
        return ans;
        
    }
}