class Solution {
    static class Pair<T, S> {
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
    public static int[] dailyTemperatures(int [] tempes){
        Map<Pair<Integer,Integer>, Integer>mp = new LinkedHashMap<>();
        int n = tempes.length;
        for(int i=0; i<n; i++){
            mp.put(new Pair<>(tempes[i], i), 0);
        }
        LinkedList<Pair<Integer, Integer>>stk = new LinkedList<>();

        for(int i=0; i<n; i++){
            Pair<Integer,Integer>curr = new Pair<>(tempes[i], i);

            while(!stk.isEmpty() && stk.peekFirst().first < curr.first){
                mp.put(stk.peekFirst(), curr.second - stk.pollFirst().second);
            }

            stk.addFirst(curr);
        }
        int [] ans = new int[n];
        int i=0;
        for(Map.Entry<Pair<Integer, Integer>, Integer> entry : mp.entrySet()){
            ans[i++] = entry.getValue();
        }
        return ans;
    }
}