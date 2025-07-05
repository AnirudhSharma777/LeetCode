class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int result = 0;
        int n = s.length();

        for(int i = 0; i<n; i++){

            int cur = hm.get(s.charAt(i));

            if(i+1 < s.length() && cur < hm.get(s.charAt(i+1))){
                result -= cur;
            }
            else{
                result += cur;
            }
        }

        return result;
    }
}