class Solution {
    int maxProduct(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            // if negative → swap max & min
            if (curr < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(curr, max * curr);
            min = Math.min(curr, min * curr);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
