//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
       // Edge case: if pattern is longer than the string
        if (s.length() < p.length()) {
            return "-1";
        }

        int[] map = new int[128];  // Array to store the count of each character in p
        
        // Fill the map with the frequency of characters in p
        for (char c : p.toCharArray()) {
            map[c]++;
        }

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = p.length();
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            
            if (map[endChar] > 0) {
                counter--;  // A valid character from p found in the current window
            }
            
            map[endChar]--;  // Decrease count in map
            end++;
            
            // When we have found a valid window (i.e., all characters of p are present)
            while (counter == 0) {
                // Update minimum length if the current window is smaller
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }

                char startChar = s.charAt(start);
                map[startChar]++;  // Revert the character count when moving start pointer

                // If the count becomes greater than 0, it means the character is needed in the window
                if (map[startChar] > 0) {
                    counter++;  // Increase counter as the window is no longer valid
                }
                
                start++;  // Shrink the window from the left
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLen);
    }
}