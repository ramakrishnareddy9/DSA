package arrays;
import java.util.Scanner;
public class ArraysPractice {
    public static void main(String[] args) {
        //datatype[] arrName = new datatype[size];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no of students:");
        int n = scan.nextInt();
        int[] marks = new int[n];
        for(int i=0;i<marks.length;i++)
            marks[i] = scan.nextInt();
        System.out.println("Marks:");
        for(int i=0;i<marks.length;i++)
            System.out.print(marks[i]+" ");
        int max = marks[0],pos=0;
        for(int i=1;i<n;i++){
            if(marks[i]>max){
                max = marks[i];
                pos = i;
            }
        }
        System.out.println("Max Marks: "+max);
        System.out.println("Max Position: "+(pos+1));
        
        int maximum = 0;
        int second_max = 0;
        for(int i=0;i<n;i++){
            if(marks[i] > max){
                second_max = maximum;
                maximum = marks[i];
            }
            else if(marks[i] > second_max && marks[i]!= maximum){
                second_max = marks[i];
            }
        }
        
        System.out.println("Second maximum value:- "+second_max);
        
    }
}
