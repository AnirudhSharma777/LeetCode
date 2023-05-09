class Solution {
public:
    
    
    bool isPossible(vector<int>& time ,int m,int mid){
        int days = 1;
        int chapter = 0;
        for(auto i :time){
            if(chapter+i <= mid){
                chapter += i;
            }
            else{
                days++;
                if(days>m || i > mid){
                    return false;
                }
                chapter = i;
            }
        }
        return true;
    }
    
    int shipWithinDays(vector<int>& weights, int days) {
        int s = 0;
	
	int sum = 0;
	for(auto i : weights){
		sum += i;
	}
    
	int e = sum;

	int mid = s + (e - s) / 2;
	int  ans = -1;

	while(s <= e){

		if(isPossible(weights,days,mid)){
			ans = mid;
			e = mid - 1;
		}
		else{
			s = mid + 1;
		}

		mid = s + (e - s) / 2;
	}

	return ans;
    }
};