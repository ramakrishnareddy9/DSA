package Recursion.QuickThinking;
/*
    pi -> 3.14
*/

/*
 * Question:
 * Replace every occurrence of pi in a string with 3.14 using recursion.
 */
public class ReplacePiWithNumber {
    static void replacePi(char[] a, int i) {
        if (a[i] == '\0' || a[i + 1] == '\0') {
            return;
        }

        if (a[i] == 'p' && a[i + 1] == 'i') {
            int j = i + 2;

            while (a[j] != '\0') {
                j++;
            }

            while (j >= i + 2) {
                a[j + 2] = a[j];
                j--;
            }

            a[i] = '3';
            a[i + 1] = '.';
            a[i + 2] = '1';
            a[i + 3] = '4';

            replacePi(a, i + 4);
        } else {
            replacePi(a, i + 1);
        }
    }

    static void printArray(char[] a) {
        for (int i = 0; a[i] != '\0'; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static String replacePi(String str) {
        if (str.length() <= 1) return str;

        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            return "3.14" + replacePi(str.substring(2));
        }

        return str.charAt(0) + replacePi(str.substring(1));
    }

    public static void main(String[] args) {
        char[] a = new char[1000];
        String str = "xpixpig";
        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i);
        }
        a[str.length()] = '\0';
        System.out.println(str);
        replacePi(a, 0);
        replacePi(str);
        printArray(a);
    }
}
