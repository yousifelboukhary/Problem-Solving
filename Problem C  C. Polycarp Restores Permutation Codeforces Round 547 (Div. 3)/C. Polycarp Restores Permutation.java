import java.util.*;
public class Main {
    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void print(Object obj){
        System.out.print(obj);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum =0;
        long mn =0;
        int [] qs = new int[n-1];
        for(int i=0; i<n-1; i++){
            qs[i] = scanner.nextInt();
            sum += qs[i];
            mn = Math.min(sum, mn);
        }
        int [] ps = new int[n];
        ps[0] = (int)(1 - mn);
        for(int i=0; i<n-1; i++){
            ps[i+1] = ps[i] + qs[i];
        }
        boolean flag = true;
        for(int i: ps)if(i < 1 || i > n){flag = false;break;}
        if(flag){
            Set<Integer>st = new HashSet<>();
            for(int i : ps)st.add(i);
            if(st.size() == n){
                for(int i : ps)print(i + " ");
            }
            else{
                print(-1);
            }
        }
        else{
            print(-1);
        }

    }
 


}
