class Solution {
    public int[] nextGreaterElement(int[] nums2, int[] nums) {
        int n = nums.length;
        LinkedList<Integer>stk = new LinkedList<>();
        Map<Integer, Integer>mp = new HashMap<>();
        int [] nextG = new int[n]; Arrays.fill(nextG, -1);
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && nums[stk.peekFirst()] < nums[i]){
                nextG[stk.pollFirst()] = nums[i];
            }
            stk.addFirst(i);
            mp.put(nums[i], i);
        }
        for(int i=0; i<nums2.length; i++){
            int z = mp.get(nums2[i]);
            nums2[i] = nextG[z];
        }
        return nums2;
    }
}