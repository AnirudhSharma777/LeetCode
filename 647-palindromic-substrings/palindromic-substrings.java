class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                String sub = s.substring(i,j+1);

                if(isPalindrom(sub)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPalindrom(String str){
        int start = 0;
        int end = str.length()-1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}