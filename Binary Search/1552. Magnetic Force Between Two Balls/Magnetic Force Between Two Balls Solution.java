class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int l =1; int r = position[position.length-1];

        int target = 1;
        return BS(position, m , l , r , target);
    }
    public static int BS(int [] positions, int m, int l, int r ,int target ){
        if(l >  r){
            return target;
        }
        int mid = (l + r)/2;
        if(SuitableDistance(positions,m , mid )){
            target = mid;
            return BS(positions, m , mid+1, r, target);
        }
        else{
            return BS(positions, m, l ,mid-1, target);
        }
    }
    public static boolean SuitableDistance(int [] positions, int m/*num of balls*/, int dis){
        int position = positions[0]; //position of the first ball
        int many_balls =1;
        for (int j : positions) {
            if (Math.abs(j - position )>= dis) {
                many_balls++;
                position = j;
            }
        }
        return many_balls >= m;
    }
}