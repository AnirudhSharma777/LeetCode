class Solution {
    public boolean isPalindrome(int x) {
        
        int temp = x;
        int reverse = 0;
        while(temp > 0){
            int last = temp % 10;
            reverse = (reverse * 10) + last;
            temp = temp / 10;
        }
        return x == reverse;
    }
}