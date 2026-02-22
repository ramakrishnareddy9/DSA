package memory;
public class Student {
	int orgID = 4523;
	String orgName = "Vignan";
	String chairman = "Dr. LaRa";
	int noOfDepts = 4;
	static double netWorth = 500.00;
	public static void main(String[] args) {
		int sID = 420;
		String sName = "Chitti";
		double fee = 2.5;
		Student s1 = new Student();
		s1.getOrgID();
		s1.getNetWorth();
		Student s2 = new Student();
		deleteStudent(sID);
	}
	public int getOrgID(){
		return orgID;
	}
	public double getNetWorth(){
		return netWorth;
	}
	public static void deleteStudent(int sID){
		/*code to delete*/
	}
}