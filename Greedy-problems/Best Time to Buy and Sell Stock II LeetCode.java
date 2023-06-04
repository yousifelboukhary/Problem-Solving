class Solution {
    public int maxProfit(int[] nums) {
        int ans =0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1] < nums[i]){
                ans += nums[i] - nums[i-1];
            }
        }
        return ans;
    }
}