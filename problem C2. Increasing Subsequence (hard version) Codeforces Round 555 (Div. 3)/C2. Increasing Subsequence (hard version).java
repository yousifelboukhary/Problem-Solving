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
        int n = scanner.nextInt();
        int[] nums = new int[n];
        boolean[] visited = new boolean[200001];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            visited[nums[i]] = true;
        }
        int l = 0;
        int r = n - 1;
        StringBuilder str = new StringBuilder();
        int numToInc = 0;
        if (nums[l] < nums[r]) {
            numToInc = nums[l];
            str.append("L");
            visited[nums[l]] = false;
            l++;
        } else if(nums[r] < nums[l]) {
            numToInc = nums[r];
            str.append("R");
            visited[nums[r]] = false;
            r--;
        }
        else{
            numToInc = Integer.MIN_VALUE;
        }
        boolean lDie = false;
        boolean rDie = false;
        int cnt = 1;
        while (l <= r) {
            if (nums[l] < numToInc || (!visited[nums[l]])) {
                lDie = true;
            }
            if (nums[r] < numToInc || !visited[nums[r]]) {
                rDie = true;
            }
            if (!lDie && nums[l] > numToInc && (nums[l] < nums[r] || nums[r] < numToInc)) {
                str.append("L");
                numToInc = nums[l];
                visited[nums[l]] = false;
                l++;

            } else if (!rDie && nums[r] > numToInc && (nums[r] < nums[l] || nums[l] < numToInc)) {
                str.append("R");
                numToInc = nums[r];
                visited[nums[r]] = false;
                r--;
            } else {
                if (nums[l] == nums[r] && nums[l] > numToInc) {
                    StringBuilder strL = new StringBuilder(str);
                    StringBuilder strR = new StringBuilder(str);
                    boolean [] visitedCopy = new boolean[visited.length];
                    int numToIncCopy =numToInc;
                    System.arraycopy(visited,0,visitedCopy,0,visited.length);
                    for (int i = l; i < r; i++) {
                        if (!visited[nums[i]])
                            break;
                        if (nums[i] > numToInc) {
                            strL.append("L");
                            visited[nums[i]] = false;
                            numToInc = nums[i];
                        }else{
                            break;
                        }
                    }
                    for (int i = r; i > l; i--) {
                        if (!visitedCopy[nums[i]])
                            break;
                        if (nums[i] > numToIncCopy) {
                            strR.append("R");
                            visitedCopy[nums[i]] = false;
                            numToIncCopy = nums[i];
                        }
                        else{
                            break;
                        }
                    }
                    if (strL.length() > strR.length()) str = strL;
                    else str = strR;
                    if (l == r && visited[nums[l]]) str.append("R");
                    break;
                }
                if (l == r && visited[nums[l]]) str.append("R");
            }
            if(rDie){
                for(int i=l; i<r; i++){
                    if(!visited[nums[i]])
                        break;
                    if(nums[i] > numToInc) {
                        str.append("L");
                        visited[nums[i]] = false;
                        numToInc = nums[i];
                    }
                }
                break;
            }
            if (lDie) {
                for (int i = r; i > l; i--) {
                    if (!visited[nums[i]])
                        break;
                    if (nums[i] > numToInc) {
                        str.append("R");
                        visited[nums[i]] = false;
                        numToInc = nums[i];
                    }
                }
                break;
            }
            cnt++;
            if (cnt == n) break;
        }
        println(str.length());
        println(str);

    }
}

