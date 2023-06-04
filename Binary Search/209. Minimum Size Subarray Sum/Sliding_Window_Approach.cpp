class Solution {
public:
  int minSubArrayLen(int target, vector<int>& nums) {
    //Using sliding window technique
    int l , r;
    l = 0; r = 0;
    int sum = 0;
    int len = INT_MAX;
    while(r < nums.size()){
        sum += nums[r];
        while (sum >= target){
            len = min(len, (r - l + 1/*window len*/));
            sum -= nums[l++];
        }
        r++;
    }
    return len == INT_MAX ? 0 : len;
}
};
