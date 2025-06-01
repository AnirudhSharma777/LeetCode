/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    
    let n = nums.length;
    
    let arr = new Array(n).fill(0);

    arr[0] = 1;

    for(let i = 1; i<n; i++){
        arr[i] = nums[i-1] * arr[i-1];
    }

    let right = 1;
    for(let i = n-1; i>=0; i--){
        arr[i] *= right;
        right *= nums[i];
    }

    return arr;
};