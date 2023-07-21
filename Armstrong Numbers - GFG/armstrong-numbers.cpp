//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    string armstrongNumber(int n){
        // code here
        int size = 0;
        int temp = n;
        while(temp != 0){
            temp = temp / 10;
            size++;
        }
        temp = n;
        int ans = 0;
        while(temp != 0){
            int last = temp % 10;
            
            ans  += (int) pow(last,size);
            temp = temp / 10;
        }
        
        return ans == n ? "Yes" : "No";
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.armstrongNumber(n) << endl;
    }
    return 0;
}

// } Driver Code Ends