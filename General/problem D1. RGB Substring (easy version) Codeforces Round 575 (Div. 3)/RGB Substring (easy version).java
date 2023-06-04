
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
        int q = scanner.nextInt();
        while(q-- > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String subs = scanner.next();
            int cntDifferences = Integer.MAX_VALUE;
            for(int i=0; i<n-k+1 ; i++){
                String str = subs.substring(i,i+k);
                cntDifferences = Math.min(cntDifferences, numOfDifferences(str));
            }
            println(cntDifferences);
        }

    }

    public static int numOfDifferences(String str){
        String [] strings = { "RGB", "BRG", "GBR" };
        int cnt = Integer.MAX_VALUE;
        for(String ss : strings){
            int lcnt = 0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) != ss.charAt(i%3)){
                    lcnt++;
                }
            }
            cnt = Math.min(cnt, lcnt);
        }
        return cnt;
    }
}
