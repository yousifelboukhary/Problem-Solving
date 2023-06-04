class Solution {
           public static String removeKdigits(String num, int k){
        StringBuilder ans = new StringBuilder();
        LinkedList<Integer>stk = new LinkedList<>();
        int n = num.length();
        int t = k;
        for(int i=0; i<n; i++){
            int x = num.charAt(i) - '0';
            while(!stk.isEmpty() && k > 0 && stk.peekFirst() > x){
                stk.pollFirst();
                k--;
            }
            stk.addFirst(x);
        }
        while (!stk.isEmpty() && stk.peekLast() == 0){
            stk.pollLast();
            t++;
        }
        if(stk.isEmpty())return "0";
        n -= t;
        for(int i=0; i<n; i++){
            ans.append(stk.pollLast());
        }
        if(ans.isEmpty())ans.append("0");
        return ans.toString();
    }
}