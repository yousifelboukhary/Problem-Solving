import java.util.*;

public class Main {
    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void print(Object obj){
        System.out.print(obj);
    }
    
    static class TNode{
        private Integer l;
        private Integer r;
        TNode(Integer l , Integer r){
            this.l = l;    this.r = r;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String ch = scanner.next();
        int rootNodeValue = scanner.nextInt();
        TNode rootNode = new TNode(0,0);
        Map<Integer, TNode>mp = new HashMap<>();
        mp.put(rootNodeValue, rootNode);  n--;
        int l =0; int r = 0;
        while(n-- > 0){
            String str = scanner.next();
            if(str.charAt(0) == 'L'){
                l++;
                TNode tNode =new TNode(l,null);
                int i = scanner.nextInt();
                mp.put(i, tNode);
            }
            else if(str.charAt(0) == 'R'){
                r++;
                TNode tNode =new TNode(null,r);
                int i = scanner.nextInt();
                mp.put(i, tNode);
            }
            else{
                int num = scanner.nextInt();
                TNode ref = mp.get(num);
                if(num == rootNodeValue)
                    println(Math.min(l,r));
                else if(ref.l == null){
                    println(Math.min(r-ref.r, l +ref.r));
                }
                else{
                    println(Math.min(l-ref.l, r +ref.l));
                }
            }
        }
    }
}