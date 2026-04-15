package BinarySearch;

/*
Problem: PRATA – Roti Prata
IEEE is having its AGM next week, and the president wants to serve cheese pratas after the meeting.
The subcommittee members must get P pratas packed.
There are L cooks available, and each cook has a rank R.

Cooking Rule :

    A cook with rank R:
        Takes R minutes to cook the 1st prata
        Takes 2R minutes for the 2nd prata
        Takes 3R minutes for the 3rd prata
        And so on...

    Total time to cook k pratas:
        R × (1 + 2 + 3 + ... + k) = R × k(k+1)/2
    A cook can only cook a prata if full time is available (no partial cooking).

Objective :
    Find the minimum time required to cook P pratas using all cooks.

Input Format :
    First line contains integer T → number of test cases
    For each test case:
    First line: integer P → number of pratas required
    Second line:
    First integer L → number of cooks
    Followed by L integers → ranks of cooks
Output Format :
    For each test case:
    Print a single integer → minimum time required
Constraints :
    1 ≤ T ≤ 50
    1 ≤ P ≤ 1000
    1 ≤ L ≤ 50
    1 ≤ R ≤ 8
Input:
    1
    10
    4 1 2 3 4
Output:
    12
*/

public class Pratas {
    
}
