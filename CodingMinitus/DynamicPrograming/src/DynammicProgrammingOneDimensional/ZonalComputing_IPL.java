/*
 * QUESTION: Zonal Computing - IPL (Olympiad 2014)
 * In IPL 2025, the amount that each player is paid varies from match to match. The match fee depends on the quality of opposition, the venue etc.
 * The match fees for each match in the new season have been announced in advance. Each team has to enforce a mandatory rotation policy
 * so that no player ever plays three matches in a row during the season.
 * Nikhil is the captain and chooses the team for each match. He wants to allocate a playing schedule for himself to maximize his earnings
 * through match fees during the season.
 * Constraint: No player can play 3 consecutive matches.
 */
package DynammicProgrammingOneDimensional;

// to solve this problem let use the previous problem ZonalComputing_Supw as we know we get the min val inn previous so lets add the total array and sub the ans from total sum

public class ZonalComputing_IPL {
    static int supw_Tabulation(int a[]) {
        int dp[] = new int[a.length];
        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];

        for (int i = 3; i < a.length; i++) {
            dp[i] = a[i] + Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        }
        return Math.min(dp[a.length - 1], Math.min(dp[a.length - 2], dp[a.length - 3]));
    }

    static int IPL(int a[]) {
        int sum = 0;
        for (int s : a) {
            sum += s;
        }
        return sum - supw_Tabulation(a);
    }

    public static void main(String[] args) {
        int a[] = { 3, 2, 3, 2, 3, 1, 5, 3 };
        System.out.println(IPL(a));
    }
}
