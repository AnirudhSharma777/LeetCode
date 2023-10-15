class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int l = 0,r = 0, n = s.size(), ans = 0;
        unordered_map<char,int> m;
        for(;r<n; r++){
            m[s[r]]++;
            for(;m[s[r]] > 1; l++){
                m[s[l]]--;
            }
            ans = max(ans,r-l+1);
        }
        return ans;
    }
};