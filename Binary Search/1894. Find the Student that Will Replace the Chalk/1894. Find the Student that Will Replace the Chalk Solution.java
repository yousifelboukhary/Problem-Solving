class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum_of_chalks = 0;
        for(int ch : chalk){
            sum_of_chalks += ch;
        }
        int i = 0;
        long k2 =k;
        k2 = k2 % sum_of_chalks;
        k= (int)k2;
        while(k > 0){
            k -= chalk[i];
            if(k >= 0){
                i++;        
                }
        }
        return i;
    }
}