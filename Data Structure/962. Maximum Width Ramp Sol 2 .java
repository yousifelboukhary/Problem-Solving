class Solution {
        public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int [] min = new int[n];
        min[0] = nums[0];
        int [] mx = new int[n];
        mx[n-1] = nums[n-1];
        for(int i =1; i<n; i++){
            min[i] = Integer.min(min[i-1], nums[i]);
        }
        for(int i=n-2; i>=0; i--){
            mx[i] = Integer.max(mx[i+1], nums[i]);
        }
        int l =0;
        int r= 0;
        int ans = 0;
        while(r<n){
            if(min[l] <= mx[r]){
                ans = Integer.max(ans, r-l);
                r++;
            }
            else{
                l++;
            }
        }
        return ans;
    }

}