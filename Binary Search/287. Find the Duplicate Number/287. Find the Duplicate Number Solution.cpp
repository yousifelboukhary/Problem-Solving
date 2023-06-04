class Solution {
public:
    int bs(const vector<int>& vec, int l , int r, int & idx){
        if( l > r)
            return idx;
        int mid = (l+r)/2;
        if(vec[mid] <= mid){
            idx = mid;
            return bs(vec, l ,mid-1, idx);
        }
        else{
            return bs(vec, mid+1, r  , idx);
        }
    }
    int findDuplicate(vector<int>& nums) {
    //sort + binary search -> lets do it    
    sort(nums.begin(), nums.end());
    int idx =0;
    bs(nums, 0 , nums.size()-1 ,idx);
    return nums[idx];
    }
};