// // 115. Distinct Subsequences
// Hard

// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// It is guaranteed the answer fits on a 32-bit signed integer.

 

// Example 1:

// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from S.
// rabbbit
// rabbbit
// rabbbit
// Example 2:

// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from S.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag
 

// Constraints:

// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
// link --> https://leetcode.com/problems/distinct-subsequences/

class Solution {
    int [][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) Arrays.fill(dp[i], -1);
        return solve(s, t, s.length(), t.length());
    }
    private int solve(String s, String t, int n, int m) {
        if (m == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        
        dp[n][m] = (solve(s, t, n - 1, m));
        if (s.charAt(n - 1) == t.charAt(m - 1)){
            dp[n][m] += solve(s, t, n - 1, m - 1);
        }
        return dp[n][m];
    }
}

// or

class Solution {
    int [][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) Arrays.fill(dp[i], -1);
        int ans = solve(s, t, s.length(), t.length());;
        
        
        return dp[s.length()][t.length()];
    }
    private int solve(String s, String t, int n, int m) {
        if (m == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        
        if (s.charAt(n - 1) != t.charAt(m - 1)){
            dp[n][m] = solve(s, t, n - 1, m);
        }else{
            dp[n][m] = solve(s, t, n - 1, m) + solve(s, t, n - 1, m - 1);
        }
        return dp[n][m];
    }
}