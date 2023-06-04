class Solution {
    public static int maximumRemovals(String s, String p, int[] removable) {
        int l =1;
        int r = removable.length;
        int k =0;
        k = getK(s, p ,removable, l ,r, k);
        return k;
    }
    public static int getK(String s, String p, int [] removable, int l , int r, int k ){
        if(l > r){
            return k;
        }
        int mid = (l + r)/2;
        if(isCompatible(mid , s , p , removable)){
            k = mid;
            return getK(s, p ,removable, mid+1, r , k);
        }
        else{
            return getK(s, p , removable, l ,mid-1 , k);
        }
    }
    public static boolean isCompatible(int k , String s, String p, int [] removable){
        char [] chs = s.toCharArray();
        for(int i=0; i< k;i++){
            chs[removable[i]] = '/';
        }
        Stack<Character>stk = new Stack<>();
        for(char ch : p.toCharArray()){
            stk.push(ch);
        }
        for(int i= s.length()-1; i>=0; i--){
            if(!stk.isEmpty() && stk.peek() .equals(chs[i])){
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}