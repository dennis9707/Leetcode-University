package LongestPalindromicSubstring;

public class Solution2 {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        char[] charArray = s.toCharArray();

        int maxLen = 1;
        int begin = 0;
        for(int i = 0; i < len - 1; i++){
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i+1);

            int curManLen = Math.max(oddLen, evenLen);
            if(curManLen > maxLen){
                maxLen = curManLen;

                begin = i - (maxLen - 1) / 2;
            }

        }

        return s.substring(begin, begin + maxLen);
    }

    private int expandAroundCenter(char[] charArray, int left, int right) {
        int len = charArray.length;
        int i = left;
        int j = right;

        while(i >= 0 && j < len){
            if(charArray[i] == charArray[j]){
                i--;
                j++;
            }
            else{
                break;
            }
        }

        return j - i - 1;
    }
}
