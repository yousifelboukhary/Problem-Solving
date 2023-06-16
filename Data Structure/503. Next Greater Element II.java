class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        LinkedList<Integer>stk = new LinkedList<>();
        int [] ans = new int[n]; Arrays.fill(ans, -1);
        for(int i=0; i<n*2; i++){
            while(!stk.isEmpty() && nums[stk.peekFirst()] < nums[i%n]){
                ans[stk.pollFirst()] = nums[i%n];
            }
            stk.addFirst(i%n);
        }
        return ans;
    }
}