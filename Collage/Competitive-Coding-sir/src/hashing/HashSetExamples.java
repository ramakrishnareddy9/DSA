package hashing;
import java.util.*;
public class HashSetExamples {
	public static void main(String[] args) {
		//creation
		HashSet<Integer> set = new HashSet();
		System.out.println(set);
		//addition
		set.add(10);
		set.add(20);
		set.add(5);
		System.out.println(set);
		set.add(10);
		System.out.println(set);
		//retreival
		for(int val : set)
			System.out.println(val);
		//verification
		System.out.println(set.contains(10));
		System.out.println(set.contains(100));
		//updation is not possible
		//deletion
		set.remove(10);
		set.clear();
		System.out.println(set);
	}
}