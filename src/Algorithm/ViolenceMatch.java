package Algorithm;

public class ViolenceMatch {
    public static int violenceMatch(String str1, String str2){

        int s1Lens = str1.length();
        int s2lens = str2.length();

        int i=0;
        int j=0;

        while(i<s1Lens && j<s2lens){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == s2lens){
            return i - j;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String str1 = "abcabcabc";
        String str2 = "cab";
        int index = violenceMatch(str1,str2);
        System.out.println(index);
    }
}
