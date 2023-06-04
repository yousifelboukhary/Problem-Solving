class Solution {
    public int minimumSize(int [] nums, int maxOperations){
        int l = 1;
        int mx = Integer.MIN_VALUE;
        for(int num : nums){
            mx = Math.max(mx, num);
        }
        int r = mx;
        int ans =0;
        while (l <= r){
            int mid = (l + r)/2;
            if(isCompatible(nums,maxOperations,mid)){
                ans = mid;
                r = mid -1;
            }
            else{
                l=mid +1;
            }
        }
        return ans;
    }
    public static boolean isCompatible(int [] nums, int maxOperations, int target){
        int cnt = 0;
        for(int num : nums){
            cnt += (num - 1)/target;
        }
        return cnt <= maxOperations;
    }

}