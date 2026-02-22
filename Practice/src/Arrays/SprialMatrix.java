// Given an mXn matrix, return all elements of the matrix in spiral order. 
// Input: 
// 3 3 
// 1 2 3 
// 4 5 6 
// 7 8 9 
// Output: 
// 1 2 3 6 9 8 7 4 5 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SprialMatrix {
    static List<Integer> sprialMatrix(int arr[][]){
        ArrayList<Integer> list = new ArrayList<>();

        int rowStart = 0, columnStart = 0;
        int rowEnd = arr.length - 1, columnEnd = arr[0].length - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {

            for (int i = columnStart; i <= columnEnd; i++) {
                list.add(arr[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(arr[i][columnEnd]);
            }
            columnEnd--;

            if (rowStart <= rowEnd) {
                for (int i = columnEnd; i >= columnStart; i--) {
                    list.add(arr[rowEnd][i]);
                }
                rowEnd--;
            }

            if (columnStart <= columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(arr[i][columnStart]);
                }
                columnStart++;
            }
        }

        return list;
    } 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = s.nextInt();
            }
        }

        System.out.println(sprialMatrix(arr));
        s.close();
    }
}
