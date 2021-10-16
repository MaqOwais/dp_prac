// 1092. Shortest Common Supersequence
// Hard

// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

// Example 1:

// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.
// Example 2:

// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"
 
// Constraints:

// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of lowercase English letters.

// link --> https://leetcode.com/problems/shortest-common-supersequence/



class Solution {
    int[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
         if (str1.length() > str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) 
            for (int j = 0; j < str2.length() + 1; j++)
                dp[i][j] = -1;
        
        solve(str1, str2, str1.length(), str2.length());
        String s = "";
        int n = str1.length(), m = str2.length();
        while(n > 0 && m > 0){
            if (str1.charAt(n - 1) == str2.charAt(m - 1)){
                s += str2.charAt(m - 1);
                n--;m--;
            }else{
                if (dp[n][m - 1] > dp[n - 1][m]){
                    s += str2.charAt(m - 1);
                    m--;
                }else{
                    s += str1.charAt(n - 1);
                    n--;
                }
            }
        }
        while(n > 0) {
            s += str1.charAt(n - 1);
            n--; 
        }
        while(m > 0) {
           s += str2.charAt(m - 1);
            m--; 
        }
        return reverse(s);
    }
    private int solve(String s1, String s2, int n, int m){
        if (n == 0 || m == 0) return 0;
        
        if (dp[n][m] != -1) return dp[n][m];
        
        if (s1.charAt(n - 1) == s2.charAt(m - 1)){
            dp[n][m] = 1 + solve(s1, s2, n - 1, m - 1);
        }else{
            dp[n][m] = Math.max(solve(s1, s2, n, m - 1), solve(s1, s2, n - 1, m));
        }
        
        return dp[n][m];
    }
    `
    private String reverse(String s){
        int j = s.length() - 1;
        String str = "";
        while (j >= 0){
            str += s.charAt(j);
            j--;
        }
        return str;
    }
}