package arrays;
import java.util.Arrays;
import java.util.Scanner;
public class ArraysPractice2D {
    public static void main(String[] args) {
        /*
        int[][] arr = new int[][]{{1,2},{3,4},{5,6}};
        for(int[] row:arr)
            System.out.println(Arrays.toString(row));
        int[][] arr2 = new int[4][];
        arr2[0] = new int[]{1,2,3,4};
        arr2[1] = new int[]{5,6};
        arr2[2] = new int[]{7};
        arr2[3] = new int[]{8,9};
        System.out.println("Jagged Array:");
        for(int[] row:arr2)
            System.out.println(Arrays.toString(row));
     */
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = scan.nextInt();
        int fSum=0,bSum=0;
        for(int i =0;i<rows;i++){
            fSum += mat[i][i];
            bSum += mat[i][rows-1-i];
        }
        if(fSum==bSum)
            System.out.println("SuperDuper");
        else if(fSum>bSum)
            System.out.println("Super");
        else
            System.out.println("Duper");
    }
}


