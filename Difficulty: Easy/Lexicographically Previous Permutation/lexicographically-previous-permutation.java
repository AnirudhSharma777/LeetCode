class Solution {
    public String prevPermutation(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Step 1: Find first decreasing element from right
        int i = n - 2;

        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        // If already smallest permutation
        if (i < 0) {
            return s;
        }

        // Step 2: Find just smaller element from right
        int j = n - 1;

        while (arr[j] >= arr[i]) {
            j--;
        }

        // Step 3: Swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Step 4: Reverse suffix
        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;

            left++;
            right--;
        }

        return new String(arr);
    }
}