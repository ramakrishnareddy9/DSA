package strings;
public class StringBufferPractice {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("Vignan");
        System.out.println(sb1.capacity());
        
        sb1.append("University",3,10);
        System.out.println(sb1);
        sb1.insert(6, " Uni");
        System.out.println(sb1);
        sb1.insert(17, " Guntur",0,7);
        System.out.println(sb1);
        sb1.setCharAt(3, 'm');
        System.out.println(sb1);
        sb1.delete(17, 24);
        System.out.println(sb1);
        sb1.deleteCharAt(5);
        System.out.println(sb1);
        sb1.replace(3, 5, "nan");
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
    }
}