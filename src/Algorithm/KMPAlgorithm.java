package Algorithm;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCACABCABA";
        String str2 = "ABCAB";
    }
    public static int kmpSearch(String str1, String str2, int[] next){
        for(int i=0,j=0;i<str1.length();i++){
            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;

    }
    public static int[] kmpnext(String dest){
//         create a "next" array
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i=0,j=0;i<dest.length();i++){
            while(j>0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
