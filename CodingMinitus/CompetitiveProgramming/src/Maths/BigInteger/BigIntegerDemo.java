package Maths.BigInteger;

import java.math.BigInteger;
import java.util.Random;

/*
 * Question:
 * Demonstrate arithmetic and utility operations using BigInteger.
 */
public class BigIntegerDemo {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("123456789012345678901234567890");
        BigInteger b = new BigInteger("98765432109876543210");
        BigInteger mod = new BigInteger("1000000007");

        System.out.println("==== BASIC ARITHMETIC ====");
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("a / b = " + a.divide(b));
        System.out.println("a % b (remainder) = " + a.remainder(b));
        System.out.println("a mod b = " + a.mod(b));

        System.out.println("\n==== POWER / GCD ====");
        System.out.println("b^3 = " + b.pow(3));
        System.out.println("gcd(a, b) = " + a.gcd(b));

        System.out.println("\n==== MODULAR OPERATIONS ====");
        System.out.println("a^2 mod 1e9+7 = " + a.modPow(BigInteger.valueOf(2), mod));
        System.out.println("inverse of b mod 1e9+7 = " + b.modInverse(mod));

        System.out.println("\n==== COMPARISON ====");
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println("min(a, b) = " + a.min(b));
        System.out.println("max(a, b) = " + a.max(b));

        System.out.println("\n==== SIGN / ABS ====");
        System.out.println("abs(-a) = " + a.negate().abs());
        System.out.println("-a = " + a.negate());
        System.out.println("signum(a) = " + a.signum());

        System.out.println("\n==== BIT OPERATIONS ====");
        System.out.println("a & b = " + a.and(b));
        System.out.println("a | b = " + a.or(b));
        System.out.println("a ^ b = " + a.xor(b));
        System.out.println("~a = " + a.not());
        System.out.println("a & ~b (andNot) = " + a.andNot(b));
        System.out.println("a << 2 = " + a.shiftLeft(2));
        System.out.println("a >> 2 = " + a.shiftRight(2));
        System.out.println("testBit(5) = " + a.testBit(5));
        System.out.println("setBit(5) = " + a.setBit(5));
        System.out.println("clearBit(5) = " + a.clearBit(5));
        System.out.println("flipBit(5) = " + a.flipBit(5));
        System.out.println("bitCount(a) = " + a.bitCount());
        System.out.println("bitLength(a) = " + a.bitLength());
        System.out.println("lowest set bit index in a = " + a.getLowestSetBit());

        System.out.println("\n==== DIVIDE & REMAINDER ====");
        BigInteger[] qr = a.divideAndRemainder(b);
        System.out.println("quotient = " + qr[0]);
        System.out.println("remainder = " + qr[1]);

        System.out.println("\n==== PRIME UTILITIES ====");
        System.out.println("a is probable prime? " + a.isProbablePrime(20));
        System.out.println("next probable prime after a = " + a.nextProbablePrime());
        BigInteger randomPrime = BigInteger.probablePrime(32, new Random());
        System.out.println("random 32-bit probable prime = " + randomPrime);

        System.out.println("\n==== CONVERSIONS ====");
        System.out.println("intValue(a) = " + a.intValue());
        System.out.println("longValue(a) = " + a.longValue());
        System.out.println("doubleValue(a) = " + a.doubleValue());
        System.out.println("byte array length(a) = " + a.toByteArray().length);
        System.out.println("a as decimal = " + a.toString());
        System.out.println("a as binary = " + a.toString(2));
        System.out.println("a as hex = " + a.toString(16));

        System.out.println("\n==== CONSTANTS / FACTORIES ====");
        System.out.println("ZERO = " + BigInteger.ZERO);
        System.out.println("ONE = " + BigInteger.ONE);
        System.out.println("TEN = " + BigInteger.TEN);
        System.out.println("valueOf(123456) = " + BigInteger.valueOf(123456));

        System.out.println("\n==== EXACT CONVERSION METHODS ====");
        BigInteger small = BigInteger.valueOf(120);
        System.out.println("byteValueExact(120) = " + small.byteValueExact());
        System.out.println("shortValueExact(120) = " + small.shortValueExact());
        System.out.println("intValueExact(120) = " + small.intValueExact());
        System.out.println("longValueExact(120) = " + small.longValueExact());
    }

}
