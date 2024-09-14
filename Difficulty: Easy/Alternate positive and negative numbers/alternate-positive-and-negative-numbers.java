//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        Vector<Integer> pos = new Vector<>();
        Vector<Integer> neg = new Vector<>();
        
        int i  = 0;
        while(i<arr.size()){
            if(arr.get(i) >= 0){
                pos.add(arr.get(i));
            }else{
                neg.add(arr.get(i));
            }
            i++;
        }
        
        arr.clear();
        i = 0;
        int j = 0;
        int k = 0;
        while(k<n){
            if(k % 2 == 0){
                if(i == pos.size()){
                    break;
                }
                arr.add(pos.get(i));
                i++;
                
            }
            else{
                if(j == neg.size()){
                    break;
                }
                arr.add(neg.get(j));
                j++;
              
            }
            k++;
        }
        
         while(i!=pos.size()){
            arr.add(pos.get(i));
            k++;
            i++;
        }
        while(j!=neg.size()){
            arr.add(neg.get(j));
            k++;
            j++;
        }
        
    }
}