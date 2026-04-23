package BinarySearch;

/*
There is a long wire along at stright line which contains N birds nests at positions x1,x2...xn

There are B(B<=N) birds, which become angry towards each other once put into a nest .To put the birds from hunting each other you want to assign birds to nests such that minimum distance b/w any two birds is as large as possible. What is the largest minimum distance?

*/

public class AngryBirds {

    static boolean canPlace(int[] nests, int birds, int dist) {
        int count = 1;
        int lastPos = nests[0];

        for (int i = 1; i < nests.length; i++) {
            if (nests[i] - lastPos >= dist) {
                count++;
                lastPos = nests[i];

                if (count >= birds) return true;
            }
        }
        return false;
    }

    static int maxMinDistance(int[] nests, int birds) {
        int low = 1;
        int high = nests[nests.length - 1] - nests[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(nests, birds, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nests = {1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(maxMinDistance(nests, k));
    }
}
