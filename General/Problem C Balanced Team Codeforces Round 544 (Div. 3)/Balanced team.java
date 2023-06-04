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
        int [] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }

        //First Sort
        Arrays.sort(nums);
        //Second Apply binary search
        int mx = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int l = i;
            int r = n - 1;
            int index = i;
            while (l <= r) {
                int mid = (l+r)/2;
                if(nums[mid] - nums[i] <=5){
                    index = mid;
                    l= mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            if(mx < index -i +1){
                mx = index-i+1;
            }
        }
        println(mx);
    

    }
}