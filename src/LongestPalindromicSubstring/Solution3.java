package LongestPalindromicSubstring;

public class Solution3 {
    /**
     * 状态转移： dp[i][j] 表示子串 s[i..j]
     * d[i][j] = (s[i] == s[j]) and dp[i + 1] [j - 1]
     */
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        char[] charArray = s.toCharArray();

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i ++){
            dp[i][i] = true;
        }
        for(int j = 1; j < len ; j++){
            for(int i = 0; i < j; i++){
                if( charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }
                else{
                    if( j - i < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
