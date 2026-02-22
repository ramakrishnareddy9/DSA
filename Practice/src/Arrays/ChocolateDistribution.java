// Chocolate Distribution Problem 
// Given  an  array  of  N  integers  where  each  value  represents  the  number  of 
// chocolates  in  a  packet.  Each  packet  can  have  a  variable  number  of 
// chocolates.  There  are  m  students,  the  task  is  to  distribute  chocolate 
// packets such that: 
// •Each student gets one packet. 
// •The difference between the number 
// with maximum chocolates  and 
// of chocolates in 
// the    packet with 
// the packet 
// minimum 
// chocolates given to the students is minimum. 
// Input: 
// 8 
// 3 4 1 9 56 7 9 12 
// 5 
// Output: 
// 6 3,  4,  7,  9,  and  9  is  been  distributed  among  the  5  children,  so  the 
// difference    between    the    number    of    chocolates    in    the    packet 
// with  maximum  chocolates  and  packet  with  minimum  chocolates  would 
// be 9 - 3 = 6 

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution{
    static int chocolateDistribution(int arr[],int n){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i <= arr.length - n;i++){
            int diff = arr[i + n - 1] - arr[i];
            min = Math.min(diff,min);
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        int m = s.nextInt();
        System.out.println(chocolateDistribution(arr,m));
        s.close();
    }
}