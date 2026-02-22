package strings;

import java.util.Scanner;

public class NumberToWords {
    static String numberToWords(int n){
        if (n == 0) return "Zero";

        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        int i = 0;
        String res = "";

        while(n > 0){
            if(n % 1000 != 0){
                String part = "";
                int pos = n % 1000;
                if(pos >= 100){
                    part += ones[pos / 100] + " ";
                    pos %= 100;
                }
                if(pos >= 20){
                    part += tens[pos / 10] + " ";
                    pos %= 10;
                }
                if(pos > 0){
                    part += ones[pos] + " ";
                }
                if(!thousands[i].isEmpty()){
                    part += thousands[i] + " ";
                }
                res = part + res;
            }
            n /= 1000;
            i++;
        }
        return res.trim();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(numberToWords(n));
        s.close();
    }
}
