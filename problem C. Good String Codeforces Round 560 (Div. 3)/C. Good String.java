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
        int n  =scanner.nextInt();
        String str = scanner.next();
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        int odd = 0;
        boolean flag = true;
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            ans.append(ch);
            if(odd == 0){
                while((i + 1 < n) && str.charAt(i+1) == ch){
                    i++;
                    cnt++;
                }
                odd ^= 1;
                flag = false;
            }
            if(flag){
                odd ^=  1;
            }
            flag = true;
        }
        if((ans.length() & 1) == 1){
            cnt++;
            ans.deleteCharAt(ans.length()-1);
        }
        println(cnt);
        print(ans);
    }

}

