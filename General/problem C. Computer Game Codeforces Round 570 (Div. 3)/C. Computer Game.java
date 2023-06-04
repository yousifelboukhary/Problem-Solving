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
            int charge = scanner.nextInt();
            int turns = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int A = charge / a;
            if(charge % a == 0) A--;
            int ans = -1;
            int l=0; int r = A;
            while(l <= r){
                int mid = (l+r)/2;
                if(valid(mid,turns,charge,a,b)){
                    ans = mid;
                    l = mid+1;
                }
                else{
                    r= mid-1;
                }
            }
            if(ans > turns)
                ans = turns;
            println(ans);
        }
    }
    private static boolean valid(int mid, int turns, int charge, int a, int b){
        int z = a*mid;
        int remaining = charge - z;
        int B = remaining / b;
        if(remaining % b == 0) B--;
        return (mid+B >= turns);
    }

}

