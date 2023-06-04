class Solution {
public:
    int triangleNumber(vector<int>& nums){
    sort(nums.begin(), nums.end());
    int n = static_cast<int>(nums.size());
    int solution = 0;
    for(int i=0; i < n; i++){
        int j = i + 1;
        while (j < n){
            int sum = nums[i] + nums [j];
            int cnt =0;
            bs(nums, j+1 , n - 1 , sum , cnt);
            solution += cnt;
            j++;
        }
    }
    return solution;
}
int bs(vector<int> & sub_nums, int l ,int r, int key, int & cnt){
    if(l > r)
        return cnt;
    int mid = (l + r) / 2;
    if(sub_nums[mid] < key){
        cnt  += mid - l +1  ;
        return bs(sub_nums, mid + 1, r , key , cnt );
    }
    else{
        return bs(sub_nums, l, mid - 1, key, cnt);
    }
}
};
