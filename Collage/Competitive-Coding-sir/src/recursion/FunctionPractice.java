package recursion;

public class FunctionPractice {
	static Student updateInfo(Student s){
		s.adress = "Vignan,DSNR,Hyderabad";
		s.cgpa = 9.9f;
		return s;
	}
	public static void main(String[] args) {
		Student s1 = new Student();
		updateInfo(s1);
		System.out.println(s1.ID);
		System.out.println(s1.name);
		System.out.println(s1.cgpa);
		System.out.println(s1.adress);

	}

}
class Student{
	int ID = 420;
	String name = "Chitti";
	float cgpa = 9.0f;
	String adress = "Vignan,Vadlamudi,Guntur";
}