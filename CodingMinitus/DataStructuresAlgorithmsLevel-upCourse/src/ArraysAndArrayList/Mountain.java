package ArraysAndArrayList;

/*
Write a function that takes input an array of distinct integers, and returns the length of highest mountain.
• A mountain is defined as adjacent integers that are strictly increasing until they reach a peak, at which they become strictly decreasing.
• At least 3 numbers are required to form a mountain.

*/

/*
 * Question:
 * Find the length of the longest mountain subarray.
 */
public class Mountain {
    static int longestMountain(int arr[]){
        int n = arr.length;
        int largest = 0;

        for (int i = 1; i <= n - 2; ) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int cnt = 1;
                int j = i;
                // count backwards (left)
                while (j >= 1 && arr[j] > arr[j - 1]) {
                    j--;
                    cnt++;
                }
                // count forwards (right)
                while (i <= n - 2 && arr[i] > arr[i + 1]) {
                    i++;
                    cnt++;
                }
                largest = Math.max(largest, cnt);
            } else {
                i++;
            }
        }
        return largest;
    }

    static int longestMountain2(int[] arr) {
        int maxCount = 0;
        int x = 0, y = 0;
        
        for (int i = 1; i < arr.length; i++) {
            
            if ((y > 0 && arr[i] > arr[i - 1]) || arr[i] == arr[i - 1]) {
                x = 0;
                y = 0;
            }
            
            if (arr[i] > arr[i - 1]) {
                x++;
            } 
            else if (arr[i] < arr[i - 1]) {
                if (x > 0) {
                    y++;
                }
            }
            
            if (x > 0 && y > 0) {
                maxCount = Math.max(maxCount, x + y + 1);
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4, 2, 1, 0, 8, 7};
        System.out.println("Longest mountain length : " + longestMountain(arr));
    }
}
