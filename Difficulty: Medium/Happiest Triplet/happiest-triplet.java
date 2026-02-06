class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        
        int i = 0, j=0, k = 0;
        int best = Integer.MAX_VALUE;
        
        int[] ans = new int[3];
        
        while(i < a.length && j < b.length && k < c.length){
            int x = a[i];
            int y = b[j];
            int z = c[k];
            
            int max = Math.max(x,Math.max(y,z));
            int min = Math.min(x,Math.min(y,z));
            
            if(max - min < best){
                best = max-min;
                ans[0] = x;
                ans[1] = y;
                ans[2] = z;
            }
            
            if(min == x){
                i++;
            }else if(min == y){
                j++;
            }
            else{
                k++;
            }
            
        }
        
          Arrays.sort(ans);
            for(int l = 0, r = 2;l < r; l++,r--){
                int temp = ans[l];
                ans[l] = ans[r];
                ans[r] = temp;
            }
            
        return ans;
    }
}
