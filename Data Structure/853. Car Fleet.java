class Solution {
    static class Pair<T, S>  {
        private T first;
        private S second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public Pair(T key, S second) {
            this.first = key;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "Key : " + first + "  " + "Value : " + second;
        }

    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        Pair<Integer, Integer>[] arr = new Pair[n];

        for(int i=0; i<n; i++){
            arr[i] = new Pair<>(position[i], speed[i]);
        }

        Arrays.sort(arr, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o2.first - o1.first;
            }
        });

        double [ ] time = new double[n];
        for(int i=0; i<n; i++){
            time[i] = (double) (target-arr[i].first) / arr[i].second;
        }
        
        int ans =0;
        LinkedList<Double>stk = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(stk.isEmpty()){
                stk.addFirst(time[i]);
                continue;
            }
            if(stk.peekFirst() < time[i]){
                while(stk.peekFirst() < time[i]){
                    stk.pollFirst();
                    if(stk.isEmpty()){
                        ans++;
                        break;
                    }
                }
            }
            if(stk.isEmpty() || stk.peekFirst() >= time[i]){
                stk.addFirst(time[i]);
            }
        }
        if(!stk.isEmpty())ans++;
        return ans;
    }
}