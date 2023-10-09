class Solution {
public:
    
    void recur(vector<char>& s,int index, int size,vector<char> & ans){
        if(index == size){
            return;
        }
        recur(s,index+1,size,ans);
        ans.push_back(s[index]);
    }
    
    void print(vector<char>& s,vector<char>& ans){
        int k = 0;
        for(auto it : ans){
            cout<<it<<" ";
            s[k++] = it;
        }
    }
    void reverseString(vector<char>& s) {
        vector<char> ans;
        recur(s,0,s.size(),ans);
        print(s,ans);
    }

};