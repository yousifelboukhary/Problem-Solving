class Solution {
    public static String removeDuplicateLetters(String s) {
        LinkedList<Integer>stk = new LinkedList<>();
        int n = s.length();
        boolean [] vis = new boolean[26];
        int [] lst = new int[26];
        int i =0;
        for(char ch : s.toCharArray()){
            lst[ch - 'a'] = i++;
        }
        i=0;
        for(; i<n; i++){
            int ch = s.charAt(i) - 'a';
            if(vis[ch])continue;
            while(!stk.isEmpty()&& stk.peekFirst() > ch && i < lst[stk.peekFirst()]){
                vis[stk.pollFirst()] = false;
            }
            stk.addFirst(ch);
            vis[ch] = true;
        }
        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            char ch = (char) (stk.pollLast() + 'a');
            ans.append(ch);
        }
        return ans.toString();
    }

}