class Solution {
public:
    string reverseWords(string s) {
        if(s.size() == 0) 
            return s;
        stack<string> st;
        string ans;
        for(int i=0; i<s.size(); i++) 
        {
            string word;
            if(s[i] == ' ') continue; 
            
            while(i < s.size() && s[i] != ' ' ) { 
                word += s[i]; 
                i++;
            }
            
            st.push(word); 
        }
        while(!st.empty()) {
            ans += st.top(); 
            st.pop();
            if(!st.empty()) 
            {
                ans += ' ';
            }
        }
        return ans;
    }
};