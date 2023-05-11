//{ Driver Code Starts
// Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template in C++

class Solution 
{
    public:
    
    bool isPossible(int A[], int n,int m,int mid){
        int no_of_Students = 1;
        int pageSum = 0;
        
        for(int i = 0; i<n; i++){
            if(pageSum + A[i] <= mid){
                pageSum += A[i];
            }
            else{
                no_of_Students++;
                if(no_of_Students > m || A[i] > mid){
                    return false;
                }
                pageSum = A[i];
            }
        }
        
        return true;
    }
    //Function to find minimum number of pages.
    int findPages(int A[], int N, int M) 
    {
        //code here
        int s = 0;
        int sum = 0;
        int ans = -1;
        
        if(M > N){
            return ans;
        }
        
        for(int i = 0; i<N; i++){
            sum += A[i];
        }
        int e = sum;
        int mid = s + (e - s) / 2;
        
        while(s <= e){
            
            if(isPossible(A,N,M,mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
            
            mid = s + (e - s) / 2;
        
        }
        
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int A[n];
        for(int i=0;i<n;i++){
            cin>>A[i];
        }
        int m;
        cin>>m;
        Solution ob;
        cout << ob.findPages(A, n, m) << endl;
    }
    return 0;
}

// } Driver Code Ends