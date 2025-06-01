/**
 * @param {number} n
 * @param {number} limit
 * @return {number}
 */

function comb(n,k) {

    if(n < 0 || k < 0 || n < k) {
        return 0;
    }

    let res = 1;
    for(let i = 1; i<=k; i++){
        res = res * (n-i+1) / i;
    }

    return res;

};
var distributeCandies = function(n, limit) {
    if(n >3*limit) {
        return 0;
    }

    let total = comb(n+2,2)
                - 3 * comb(n-limit+1,2)
                + 3 * comb(n-2 * limit, 2)
                - comb(n-3 * limit - 1, 2);

   return Math.max(total,0);

};


