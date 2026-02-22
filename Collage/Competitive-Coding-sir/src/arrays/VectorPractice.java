package arrays;
import java.util.ArrayList;
import java.util.Vector;
public class VectorPractice {
    public static void main(String[] args) {
        ArrayList v1 = new ArrayList();
        
        System.out.println(v1);
        //System.out.println(v1.capacity());
        v1.add(null);
        v1.add("Sandy");
        //System.out.println(v1.capacity());
        v1.add("Pavan");
        v1.add("Akhil");
        System.out.println(v1);
        v1.add(2,"NTR");
        System.out.println(v1);
        
        Vector v2 = new Vector();
        v2.add("SreeLeela");
        v2.add("Alia");
        v2.add("Iswarya");
        
        v1.add(v2);
        System.out.println(v1);
        
        Vector v3 = new Vector();
        v3.add("Syamala");
        v3.add("Bhumika");
        v1.add(2,v3);
       
        System.out.println(v1);
        
        Vector v4 = new Vector();
        v4.add("Nikky");
        v4.add("Vikky");
        v4.add("Jikky");
        
        v1.addAll(v4);
        System.out.println(v1);
        
        v1.addAll(1,v4);
        
        System.out.println(v1);
        
        
        System.out.println(v1.get(10));
        
        System.out.println(v1.contains("Pavan"));
        System.out.println(v1.contains(v4));
        
        System.out.println(v1.containsAll(v4));
        
        v1.set(6,"RamCharan");
        System.out.println(v1);
        
        v1.remove("Sandy");
        System.out.println(v1);
        System.out.println(v1.subList(1,5));
        v1.removeAll(v4);
        System.out.println(v1);
        
        v1.clear();
        System.out.println(v1);
        
        ArrayList<Integer> marks = new ArrayList();
        marks.add(98);
        marks.add(86);
        marks.add(75);
        
        ArrayList<Student> students = new ArrayList();
        Student s1 = new Student("Alpha",101,'A');
        Student s2 = new Student("Beta",102,'B');
        Student s3 = new Student("Gamma",103,'C');
        students.add(s1);
        students.add(s2);
        students.add(s3);
        //students.add("Theta");
        for(int i=0;i<3;i++){
            System.out.println(students.get(i).name);
        }
        
        
        ArrayList<Vector<String>> names = new ArrayList<>();
        names.add(v2);
        names.add(v3);
        System.out.println(names);
    }
}

class Student{
    String name;
    int id;
    char grade;
    Student(String name,int id,char grade){
        this.id=id;
        this.name=name;
        this.grade=grade;
    }
}