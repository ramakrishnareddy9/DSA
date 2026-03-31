package Maths.Combinatorics;

// Minimum number of people required so that probability ≥ 50% that at least two share the same birthday.

/*
 * Question:
 * Find the minimum people required so that the probability of a shared birthday reaches a threshold.
 */
public class BirthdayParadoxProblem {
    static int birthdayParadoxProblem(double n){
        double probability = 1.0;
        int people = 0;
        int numerator = 365;
        
        while (probability > n) {
            probability *= numerator / 365.0;
            numerator--;
            people++;
        }
        return people;
    }

    public static void main(String[] args) {
        System.out.println(birthdayParadoxProblem(0.5));
    }
}
