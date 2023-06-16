
//Quadratic solution
public static int[] canSeePersonsCountQuad(int[] nums) {
        int n = nums.length;
        int [] solution = new int[n];
        for(int k=0; k<n; k++){
            int turn = nums[k];
            int mx = Integer.MIN_VALUE;
            int lSol =0;
            for(int i=k+1; i<n; i++){
                mx = Integer.max(mx, nums[i]);
                if(nums[i] > turn){
                    ++lSol;
                    break;
                }
                if(nums[i] < mx)
                    continue;
                lSol++;
            }
            solution[k] = lSol;
        }
        return solution;
    }
//Imporvement with monotonic stack
public static int[] canSeePersonsCount(int[] nums) {
        int n = nums.length;
        int [] solution = new int[n];
        LinkedList<Integer>stk = new LinkedList<>();
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && nums[stk.peekFirst()] <= nums[i]){
                solution[stk.pollFirst()]++;
            }
            if(!stk.isEmpty()){
                solution[stk.peekFirst()]++;
            }
            stk.addFirst(i);
        }
        return solution;
    }