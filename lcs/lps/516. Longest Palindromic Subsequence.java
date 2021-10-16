// 516. Longest Palindromic Subsequence
// Medium

// 4121

// 230

// Add to List

// Share
// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".
// Example 2:

// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".

// link --> https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String a) {
        String b = reverse(a);
        
        dp = new int[a.length() + 1][a.length() + 1];
        
        for (int i = 0; i <= a.length(); i++) Arrays.fill(dp[i], -1);
        
        return lcs(a, b, a.length(), a.length());
    }
    
    
    private int lcs(String a, String b, int n, int m){
        if (n == 0 || m == 0) return 0;
        
        if (dp[n][m] != -1) return dp[n][m];
        
        if (a.charAt(n - 1) == b.charAt(m - 1)){
            dp[n][m] = 1 + lcs(a, b, n - 1, m - 1);
        }else{
            dp[n][m] = Math.max(lcs(a, b, n, m - 1), lcs(a, b, n - 1, m));
        }
        
        return dp[n][m];
    }
    
    
    private String reverse(String a){
        String c = "";
        while (a.length() != c.length()){
            c += a.charAt(a.length() - 1 - c.length());
        }
        return c;
    }
}