import java.util.*;

public class Main {
    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int [] cnt = new int[n+1];
            for(int i=0; i<n; i++){
                int x = scanner.nextInt();
                cnt[x]++;
            }
            Arrays.sort(cnt);
            long sum =0;
            int lst = cnt[cnt.length-1];
            sum += lst;
            for(int i=cnt.length-2; i>=0 ; i--){
                if(lst == 0)break;
                if(cnt[i] >= lst ) {
                    sum += lst -1;
                    lst= lst-1;
                }
                else{
                    sum += cnt[i];
                    lst = cnt[i];
                }
            }
            println(sum);

        }
    }

}

