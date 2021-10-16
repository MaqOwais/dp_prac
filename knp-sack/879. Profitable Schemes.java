// 879. Profitable Schemes
// Hard

// There is a group of n members, and a list of various crimes they could commit. The ith crime generates a profit[i] and requires group[i] members to participate in it. If a member participates in one crime, that member can't participate in another crime.

// Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit, and the total number of members participating in that subset of crimes is at most n.

// Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.

 

// Example 1:

// Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
// Output: 2
// Explanation: To make a profit of at least 3, the group could either commit crimes 0 and 1, or just crime 1.
// In total, there are 2 schemes.
// Example 2:

// Input: n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
// Output: 7
// Explanation: To make a profit of at least 5, the group could commit any crimes, as long as they commit one.
// There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 

// Constraints:

// 1 <= n <= 100
// 0 <= minProfit <= 100
// 1 <= group.length <= 100
// 1 <= group[i] <= 100
// profit.length == group.length
// 0 <= profit[i] <= 100
// link --> https://leetcode.com/problems/profitable-schemes/



class Solution {
    int mP;
    int[][][] dp;
    int[] group;
    int[] profit;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        // initialization
        dp = new int[len + 1][n + 1][mP + 1];
        for (int i = 0; i <= len; i++)
            for (int j = 0; j <= n; j++)
                for (int k = 0; k <= mP; k++)
                    dp[i][j][k] = -1;
        // reducing parameter by considering instance variables.
        this.mP = minProfit;
        this.group = group;
        this.profit = profit;
        return solve(n, len, mP);
    }
    private int solve(int n, int ind, int P){
        // if P is -ve implies count should be incremented by 1 instead of 0 at base cond.;
        if (n == 0 || ind < 1) return (P <= 0) ? 1 :0 ;
        P = Math.max(0, P);
        if (dp[ind][n][P] != -1) return dp[ind][n][P];
        
        if (n >= group[ind - 1]){ 
            dp[ind][n][P] = (solve(n - group[ind - 1], ind - 1, P - profit[ind - 1]) + 
                             solve(n, ind - 1, P))%1000000007;
        }else{
            dp[ind][n][P] = (solve(n, ind - 1, P))%1000000007;
        }

        return dp[ind][n][P];           
    }
}