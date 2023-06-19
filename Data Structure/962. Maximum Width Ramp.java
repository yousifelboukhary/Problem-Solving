class Solution {
        public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        LinkedList<Integer>stk = new LinkedList<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            if(stk.isEmpty() || nums[stk.peekLast()] > nums[i]){
                stk.add(i);
            }else{
                int l = 0;
                int r = stk.size()-1;
                int Lans = -1;
                while(l <= r){
                    int mid = (l + r)/2;
                    if(nums[stk.get(mid)] <= nums[i]){
                        Lans = stk.get(mid);
                        r = mid - 1;
                    }
                    else{
                        l = mid + 1;
                    }
                }
                ans = Integer.max(ans, i - Lans );
            }
        }
        return ans;
    }
}