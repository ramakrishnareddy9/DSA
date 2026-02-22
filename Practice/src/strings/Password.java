package strings;

import java.util.Scanner;

public class Password {
    static void isValid(String n){
        if(n.length() < 6){
            System.out.println("Invalid pass");
            return;
        }
        int upper = 0,smaller = 0,digit = 0;
        for(int i = 0;i < n.length();i++){
            if(Character.isUpperCase(n.charAt(i))){
                upper = 1;
            }
            else if(Character.isLowerCase(n.charAt(i))){
                smaller = 1;
            }
            else if(Character.isDigit(n.charAt(i))){
                digit = 1;
            }
            else if(n.charAt(i) == '/' || n.charAt(i) == ' '){
                System.out.println("Invalid pass");
                return;
            }
        }
        if(upper == 1 && smaller == 1 && digit == 1) System.out.println("Valid");
        else System.out.println("Invalid pass");
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        isValid(n);
        s.close();
    }
}
