package BasicRecursion;

public class PowerOfNumber {
    // time complexity = o(n)
    static int power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * power(a, n - 1);
    }

    // TimeComplexity = o(log n)
    static int power1(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = power1(a, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return a * halfPower * halfPower;
        }
    }

    public static void main(String[] args) {
        int a = 2, n = 6;
        System.out.println(power(a, n));
        System.out.println(power1(a, n));
    }
}
