class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
         int i = 0;
        int j = 0;
        
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
                sort(nums2.begin(),nums2.end());
            }
        }
        int k = i;
        while(j<n){
            nums1[k++] = nums2[j++];
        }
    }
};