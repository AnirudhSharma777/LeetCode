/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var countKDifference = function(nums, k) {
    let freq = new Array(101).fill(0);
    let pairs = 0;

    for (let num of nums) {
        // count how many numbers already seen can pair with current num
        pairs += (num - k >= 0 ? freq[num - k] : 0);
        pairs += (num + k <= 100 ? freq[num + k] : 0);

        freq[num]++;
    }

    return pairs;
};
