package LongestPalindromicSubstring;

public class Solution {
//    brute force
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        char[] charArray = s.toCharArray();

        int maxLen = 1;
        int begin = 0;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private boolean validPalindromic(char[] charArray, int left, int right) {
        while(left < right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
