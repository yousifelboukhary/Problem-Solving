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
        int [ ] nums = new int[n];
        for(int i=0; i<n;i++) {nums[i] = scanner.nextInt();}
        int l = 0; int r = n-1; StringBuilder str = new StringBuilder();
        int numToInc = 0;
        if(nums[l] < nums[r]){numToInc = nums[l]; l++;str.append("L");}
        else{numToInc = nums[r]; r--;str.append("R");}
        boolean lDie = false;   boolean rDie = false;
        int cnt = 1;
        while(l <= r){
            if(nums[l] < numToInc){lDie = true;}
            if(nums[r] < numToInc){rDie = true;}
            if(!lDie && nums[l] >numToInc && (nums[l] < nums[r] || nums[r] < numToInc)){
                str.append("L");
                numToInc = nums[l];
                l++;
            }
            else if(!rDie && nums[r] > numToInc &&( nums[r] < nums[l] || nums[l] < numToInc)){
                str.append("R");
                numToInc= nums[r];
                r--;
            }
            else{
                if(nums[l] == nums[r] && nums[l] > numToInc){str.append("L");l++;}
            }
            cnt++;
            if(cnt == n)break;
        }
        println(str.length());
        println(str);

    }

}
