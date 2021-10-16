// 583. Delete Operation for Two Strings
// Medium

// 2209

// 39

// Add to List

// Share
// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

// In one step, you can delete exactly one character in either string.

 

// Example 1:

// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
// Example 2:

// Input: word1 = "leetcode", word2 = "etco"
// Output: 4
 

// Constraints:

// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.

// link --> https://leetcode.com/problems/delete-operation-for-two-strings/

class Solution {
    int[][]  dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        
        dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = lcs(word1, word2, n, m);
        return m + n - 2*ans;
    }
    
    private int lcs(String word1, String word2, int n, int m) {
        if (n == 0) return 0;
        if (m == 0) return 0;
        
        if (dp[n][m] != -1) return dp[n][m];
        
        if (word1.charAt(n - 1) == word2.charAt(m - 1)){
            dp[n][m] = 1 + lcs(word1, word2, n - 1, m - 1);
        }else{
            dp[n][m] = Math.max(lcs(word1, word2, n - 1, m) , lcs(word1, word2, n, m - 1));
        }
        return dp[n][m];
    }
}