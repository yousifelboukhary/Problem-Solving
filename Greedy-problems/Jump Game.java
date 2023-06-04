class Solution {
    public boolean canJump(int[] nums) {
        //can't reach til the end if there no way to skip zeros or boundries
        int n = nums.length;
        if(n == 1)return true;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                if(i == n-1)//reached
                    return true;
                boolean ok = false;
                int r =i-1;
                while(r>=0 ){
                    boolean flag = false;
                    int x = nums[r];
                    while(x>0){
                        if(x+r >i && x+r <n){
                            flag = true;
                            break;
                        }
                        x--;
                    }
                    if(flag){
                        ok = true;
                        break;
                    }
                    r--;
                }
                if(!ok){
                    return false;
                }
            }
            else if(nums[i] + i >= n){
                if(i == n-1)//reached
                    return true;
                else{
                    int r = i;
                    boolean ok = false;
                    while(r >=0){
                        int x=  nums[r];
                        boolean flag = false;
                        while(x >0){
                            if(x+r > i && x+r< n){
                                flag = true;
                                break;
                            }
                            x--;
                        }
                        if(flag){
                            ok = true;
                            break;
                        }
                        r--;
                    }
                    if(!ok){
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
    
}