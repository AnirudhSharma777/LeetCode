//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            int[] arr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            long ans = ob.findSmallest(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public long findSmallest(int[] arr) {
        // Your code goes here
         long i = 1;
        long sum = 0;
        //int j = 0;
        if(arr[0] != 1)
        {
            return (long)1;
        }
        
        for(int j = 0; j < arr.length; j++)
        {
            sum += arr[j];
            if(arr[j] != j+1 && j+1 > sum)
            {
                return (long)sum+1;
            }
            else
            {
                while(j < arr.length-1 && arr[j+1] <= sum)
                {
                    sum += arr[j+1];
                    j++;
                }
                if(j < arr.length-1 && arr[j+1] > sum+1)
                {
                    return sum+1;
                }
            }
            
        }
        
        return sum+1;
    }
}