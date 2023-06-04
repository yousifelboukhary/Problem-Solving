class Solution {
    public static int maxChunksToSorted(int[] arr) {

        int n = arr.length;
        boolean [] visited = new boolean[n];
        LinkedList<Integer>stk = new LinkedList<>();
        int mx = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<n; i++){
            int x = arr[i];
            if(!stk.isEmpty()){
                if(mx < x ){
                    if(stk.size() == mx +1 || visitedForAll(mx,visited)|| mx == 0) {
                        ans++;
                        stk.clear();
                    }
                    stk.addFirst(x);
                    visited[x] = true;
                    mx = x;
                    continue;
                }
            }
            if(stk.isEmpty() || mx > x){
                stk.addFirst(x);
                visited[x] = true;
                mx = Math.max(mx,x);
            }
        }

        if(!stk.isEmpty())ans++;
        return ans;
    }


    private static boolean visitedForAll(int x, boolean[] visited) {
        for(int i=0; i<x; i++){
            if(!visited[i])return false;
        }
        return true;
    }

}