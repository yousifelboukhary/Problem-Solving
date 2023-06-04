class Solution {
public:
  int minSubArrayLen(int target, vector<int>& nums) {
    int l =1; int r = static_cast<int>(nums.size());
    int min_len = 0;
    while(l <= r){
      int mid = (l + r) / 2;
      if(check(nums, target,mid)){
        min_len = mid;
        r = mid - 1;
      }
      else{
        l = mid + 1;
      }
    }
    return min_len;
  }
private:
  bool check(const vector<int>& nums, const int & target, const int& size){
    //using sliding window to check if there is a window with size (size) >= target
    int l, r;
    l = 0; r = 0;
    int sum = 0; //window sum
    while(r < nums.size()){
      sum += nums[r];
      if(r - l + 1/*window len*/ < size){
        r++;
      }
      else{
        if(sum >= target){
          return true;
        }
        else{
          sum -= nums[l];
          l++; r++; //setting new window
        }
      }
    }
    return false;
  }
};
