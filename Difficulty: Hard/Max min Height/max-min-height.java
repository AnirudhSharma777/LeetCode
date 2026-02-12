class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int minH = Integer.MAX_VALUE;
        for (int i : arr) minH = Math.min(minH, i);

        // Binary Search Range
        long start = minH;
        long end = minH + k; // Maximum possible height we could ever achieve
        long ans = minH;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(arr, k, w, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) ans;
    }

    private boolean isPossible(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long currentWateredAmount = 0;
        long totalDaysUsed = 0;

        for (int i = 0; i < n; i++) {
            currentWateredAmount += diff[i];
            long currentHeight = arr[i] + currentWateredAmount;

            if (currentHeight < target) {
                long needed = target - currentHeight;
                totalDaysUsed += needed;

                if (totalDaysUsed > k) return false;

                currentWateredAmount += needed;
                // The watering effect stops after index i + w - 1
                if (i + w < n) {
                    diff[i + w] -= needed;
                }
            }
        }
        return totalDaysUsed <= k;
    }
}