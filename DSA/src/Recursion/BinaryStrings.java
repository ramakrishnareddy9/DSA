package Recursion;

import java.util.Scanner;

public class BinaryStrings {

    static void binaryStrings(int n,int lastDigit,String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        binaryStrings(n - 1,lastDigit,str + "1");
        if(lastDigit == 0){
            binaryStrings(n,1,str + "0");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        binaryStrings(n,0,"");
        s.close();
    }
}
