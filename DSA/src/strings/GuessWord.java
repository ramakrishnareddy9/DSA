package strings;

import java.util.Scanner;

public class GuessWord{
    static int gussWord(String arr[]){
        int maxCount = -1;
        for(int i = 0;i < arr.length;i++){
            int n = arr[i].length();
            if(n % 2 != 0){
                maxCount = Math.max(maxCount,n);
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String arr[] = new String[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.next();
        }
        System.out.println(gussWord(arr));
        s.close();
    }
}