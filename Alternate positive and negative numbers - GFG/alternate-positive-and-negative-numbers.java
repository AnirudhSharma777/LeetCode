//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        Vector<Integer> v1 = new Vector<Integer>();
        Vector<Integer> v2 = new Vector<Integer>();
        
        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                v1.add(arr[i]);
            }else{
                v2.add(arr[i]);
            }
        }
        
        // for(int i : v1){
        //     System.out.print(i+" ");
        // }
        
        int i = 0,j = 0;
        int k = 0;
        while(k<n){
            if(k % 2 == 0){
                if(i == v1.size()){
                    break;
                }
                arr[k] = v1.get(i);
                i++;
            }
            else{
                if(j==v2.size()){
                    break;
                }
                arr[k] = v2.get(j);
                j++;
            }
            k++;
        }
        
        while(i != v1.size()){
            arr[k++] = v1.get(i);
            i++;
        }
        
        while(j != v2.size()){
            arr[k++] = v2.get(j);
            j++;
        }
    }
}