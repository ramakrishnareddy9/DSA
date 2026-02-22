package strings;

import java.util.Scanner;

public class MaximumAttendance {
    static int maximumAttendance(String arr[]){
        int maxCount = 0;
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].contains("A")){
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("string size is " + n);
        int m = s.nextInt();
        String []arr = new String[m];
        for(int i = 0; i < m; i++){
            arr[i] = s.next();
        }
        System.out.println(maximumAttendance(arr));
        s.close();
    }
}
