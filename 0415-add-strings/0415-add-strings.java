class Solution {
    public String addStrings(String nums1, String nums2) {
        StringBuilder sb = new StringBuilder();
        addition(nums1,nums2,0,sb,nums1.length()-1,nums2.length()-1);
        sb.reverse();
        return sb.toString();
    }
    
    public void addition(String nums1 ,String nums2,int carry, StringBuilder sb,int i ,int j){
        if(i<0 && j < 0 && carry == 0){
            return;
        }
        
        int first = 0;
        int second = 0;
        
        if(i >= 0){
            first = nums1.charAt(i) - '0';
        }
        if(j >= 0){
            second = nums2.charAt(j) - '0';
        }
        
        int sum = first + second + carry;
        int lastDigit = sum % 10;
        carry = sum / 10;
        
        sb.append(lastDigit);
        
        addition(nums1,nums2,carry,sb,i-1,j-1);
    }
}