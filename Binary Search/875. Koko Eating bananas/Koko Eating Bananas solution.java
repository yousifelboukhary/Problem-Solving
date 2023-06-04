class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;int  r= Integer.MAX_VALUE;
        int k = 1; //any number first
        return BS(piles, l, r, k, h);
    }
    public static boolean CanEat(int [] piles, int h, int rate){
        long summation_of_rates =0;
        for(int i : piles){
            int x = (int) Math.ceil((double) i/ rate);
            summation_of_rates += x;
        }
        return summation_of_rates <= h;
    }
    public static int BS(int [] piles, int l, int r , int k, int h){
        if(l > r){
            return k;
        }
        int mid = (l + r)/2;
        if(CanEat(piles,h,mid )){
            k = mid;
            return BS(piles, l , mid -1,k, h);
        }
        else{
            return BS(piles, mid+1, r,  k , h);
        }
    }
}