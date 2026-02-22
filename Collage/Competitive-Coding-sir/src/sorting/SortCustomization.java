package sorting;
import java.util.*;
public class SortCustomization {
	public static void main(String[] args) {
		int[] arr= {3,1,4,6,2,8,9};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr,3,6);
		System.out.println(Arrays.toString(arr));
		
		Integer[] nums = {3,8,2,9,1,7}; 
		Arrays.sort(nums,Collections.reverseOrder());
		System.out.println(Arrays.toString(nums));
		
		Student[] data = {
				new Student(3,"GOne","AP"),
				new Student(1, "RaOne", "TS"),
				new Student(2, "Chitti", "MP")
		};
		Arrays.sort(data,new SortByParam());
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
		
		Arrays.sort(data,(Student s1, Student s2)->s1.name.compareTo(s2.name));
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
		System.out.println("=============**************==================");
	

		Subject[] sub = {
				new Subject(102, "DAA", 5),
				new Subject(101, "TOC", 4),
				new Subject(103, "FAD", 7),
				new Subject(111, "CC", 10)
		};
		Arrays.sort(sub,(Subject s1, Subject s2) -> s1.name.compareTo(s2.name));
		for(int i=0;i<sub.length;i++)
			System.out.println(sub[i]);
		
		System.out.println("==========****=============");
		int[][] arr2 = {{1,9},{8,2},{3,7},{6,4},{5,0}};
		Arrays.sort(arr2,(a,b)->b[1]-a[1]);
		for(int i=0;i<arr2.length;i++) {
			System.out.print(Arrays.toString(arr2[i]));

		System.out.println("==========****=============");
		String[] names = {"chandra","mani","venky","ganee","bhumik"};
		Arrays.sort(names, (s1,s2) -> s2.charAt(s2.length()-1)-s1.charAt(s1.length()-1));
		System.out.println(Arrays.toString(names));
		}
	}
}
class SortByParam implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		return s1.address.compareTo(s2.address);
	}
}
class Student{
	int id;
	String name,address;
	Student(int id, String name, String address){
		this.id = id;
		this.name=name;
		this.address=address;
	}
	public String toString() {
		return this.id+" "+ this.name+" "+this.address;
	}
}
class Subject{
	int code;
	String name;
	float credits;
	Subject(int code, String name,float credits){
		this.code = code;
		this.name = name;
		this.credits = credits;
	}
	public String toString() {
		return this.code+" "+this.name+" "+this.credits;
	}
}



