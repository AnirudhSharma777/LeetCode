class Solution {

    public ArrayList<Integer> countBSTs(int[] arr) {

        int n=arr.length;

    long[]cat=getCatlan(n);

    int[]sortArray=arr.clone();

    Arrays.sort(sortArray);

    ArrayList<Integer>ans=new ArrayList<>();

    for(int e:arr){

        int leftCnt=findFirstOcc(sortArray,e);

        int rightCnt=n-1-leftCnt;

        ans.add((int)(cat[leftCnt]*cat[rightCnt]));

    }

     return ans;  

    }

    private long[]getCatlan(int n){

        long[]c=new long[n+1];

        c[0]=1;

        if(n>0) c[1]=1;

        for(int i=2;i<=n;i++)

        for(int j=0;j<i;j++){

            c[i]+=(c[j]*c[i-1-j]);

        }

        return c;

    }

    private int findFirstOcc(int[]arr,int target){

        int low=0,high=arr.length-1;

        while(low<high){

            int mid=low+(high-low)/2;

            if(arr[mid]<target)

                //ans=mid;

                low=mid+1;

            else

            high=mid;

        }

        return low;

        }

}

