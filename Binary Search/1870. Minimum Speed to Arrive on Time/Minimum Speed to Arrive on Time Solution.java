class Solution {
    public int minSpeedOnTime(int [] dist, double hours){
        int speed =-1;
        int l =1;
        int r = 0;
        for (int i : dist){
            r = Math.max(r,i);
        }
        r =(int) 10e6;
        return BS(l , r , dist, hours, speed);
    }
    public static int BS(int l, int r, int [] dist, double hours, int speed){
        if(l > r){
            return speed;
        }
        int mid = (l + r)/2;
        if(isCompatible(mid,hours,dist)){
            speed = mid;
            return BS(l, mid-1 , dist, hours , speed);
        }
        else{
            return BS(mid+1, r, dist, hours, speed);
        }
    }
    public static boolean isCompatible(int speed, double hours, int [] dist){
        double time = 0;
        for(int i =0; i< dist.length -1; i++){
            time+= (int) Math.ceil((double) dist[i]/speed);
        }
        time += (double) dist[dist.length-1] / speed;
        return time <= hours;
    }
}