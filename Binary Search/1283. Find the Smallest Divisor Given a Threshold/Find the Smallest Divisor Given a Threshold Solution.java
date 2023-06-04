class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = -999999;
        for(int i : nums){
            r = Math.max(r,i);
        }
        int ans = 0;
        while(l <= r){
            int mid = (l + r)/2;
            if(isCompatible(mid,nums, threshold)){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;   
    }
    public static boolean isCompatible(int mid , int [] nums , int threshold){
        int sum =0;
        for(int num : nums){
            sum +=(int) Math.ceil((double)num / mid);
        }
        return sum <= threshold;
    }
}