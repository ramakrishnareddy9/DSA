// Josephus Death Trap algorithm:
// _
//  It is also known as the Josephus Problem or Josephus Permutation, is a theoretical problem in computer science and mathematics. It's named after Flavius Josephus, a Jewish historian who lived in the 1st century. The problem is based on a historical scenario, though its exact details are likely apocryphal.

// Problem Statement:

// There are n people standing in a circle, numbered from 1 to n.
// Starting from the first person, you count k people clockwise (including the starting person).
// The kth person is eliminated (or killed in the original problem).
// The process continues with the person next to the eliminated one, counting k people again, and so on.
// The goal is to find the position of the last surviving person.


// Algorithm Steps:
// a) Start with a circle of n people, numbered 1 to n.
// b) Choose a counting number k.
// c) Begin at position 1.
// d) Count k positions clockwise (wrapping around if necessary).
// e) Eliminate the person at the kth position.
// f) Continue counting from the next position.
// g) Repeat steps d-f until only one person remains.
// Mathematical Solution:

// The problem can be solved recursively or iteratively.
// The recursive formula is: f(n, k) = (f(n-1, k) + k-1) % n + 1
// Base case: f(1, k) = 1

// Implementations:

// Can be implemented using arrays, linked lists, or recursive functions.
// Circular linked lists are particularly efficient for this problem.


// Applications:

// While originally a mathematical curiosity, it has applications in load balancing, distributed computing, and some game theories.


// Variations:

// There are many variations of this problem, including changing the direction of counting, having multiple survivors, or varying k.


// Complexity:

// The naive implementation has O(n*k) time complexity.
// Optimized solutions can achieve O(n) time complexity.


// Historical Context:

// The problem is based on a story where Josephus and 40 soldiers were trapped in a cave by Roman soldiers. They decided to commit suicide by forming a circle and killing every third person, but Josephus and another person survived by figuring out the safe positions.

// This algorithm is often used as an exercise in computer science education to teach concepts of circular data structures, modular arithmetic, and recursive problem-solving. It's a classic example of how a seemingly simple problem can lead to complex mathematical and computational considerations.

import java.util.Scanner;

public class JosephusProblem
 {
    
    public static int josephus(int n, int k) 
	{
        if (n == 1)
		{
            return 1;
        } else 
		{
            // The recursive formula
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }
    
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of people (n): ");
        int n = scanner.nextInt();
        
        System.out.print("Enter the counting number (k): ");
        int k = scanner.nextInt();
        
        int survivor = josephus(n, k);
        
        System.out.println("The position of the survivor is: " + survivor);
        
        scanner.close();
    }
}