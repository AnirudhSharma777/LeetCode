//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.size();
        
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
            
            if(hm.get(i) > n / 3){
                if(!ans.contains(i)){
                    ans.add(i);
                }
            }
        }
        
        if(ans.size() == 0){
            ans.add(-1);
        }
        
        Collections.sort(ans);
        return ans;
    }
}
