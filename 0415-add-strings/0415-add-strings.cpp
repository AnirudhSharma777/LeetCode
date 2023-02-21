class Solution {
    
private:
    
    void addString(string a,string b,string& ans,int carry,int i,int j){
        
        if(i < 0 && j < 0 && carry == 0){
            return;
        }
        
        int first = 0;
        int second = 0;
        
        if(i >= 0){
            first = a[i] - '0';
        }
        if(j >= 0){
            second = b[j] - '0';
        }
        
        int sum = first + second + carry;
        int lastdigit = sum % 10;
        carry = sum / 10;
        
        ans.push_back(lastdigit + '0');
        
        addString(a,b,ans,carry,--i,--j);
        
    }
public:
    
    
    string addStrings(string num1, string num2) {
        
        string ans = "";
        addString(num1,num2,ans,0,num1.size()-1,num2.size()-1);
        reverse(ans.begin(),ans.end());
        return ans;
    }
};