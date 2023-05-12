//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
public:

    bool isPossible(vector<int>& stalls,int n,int k,int mid){
        int cnt = 1;
        int currStalls = stalls[0];
        
        for(int i = 1; i<n; i++){
            if(stalls[i] - currStalls >= mid){
                
                cnt++;
                if(cnt == k){
                    return true;
                }
                
                currStalls = stalls[i];
            }
        }
        return false;
    }
    int solve(int n, int k, vector<int> &stalls) {
    
        // Write your code here
        
        sort(stalls.begin(),stalls.end());
        
        int s = 0;
        int e = -1;
        for(auto it : stalls){
            e = max(e,it);
        }
        // cout<<e<<endl;
        int ans = -1;
        
        int mid = s + (e - s) / 2;
        while(s<=e){
            
            if(isPossible(stalls,n,k,mid)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
            
            mid = s + (e - s) / 2;
        }
        
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t = 1;
    cin >> t;

    // freopen ("output_gfg.txt", "w", stdout);

    while (t--) {
        // Input

        int n, k;
        cin >> n >> k;

        vector<int> stalls(n);
        for (int i = 0; i < n; i++) {
            cin >> stalls[i];
        }
        // char ch;
        // cin >> ch;

        Solution obj;
        cout << obj.solve(n, k, stalls) << endl;

        // cout << "~\n";
    }
    // fclose(stdout);

    return 0;
}
// } Driver Code Ends