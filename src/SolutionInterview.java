public class SolutionInterview {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i=1;i<S.length();i++){
             if(S.charAt(i-1)==S.charAt(i)){
                 count++;
             }
             else{
                 sb.append(S.charAt(i-1));
                 sb.append(count);
                 count = 1;
             }
        }
        sb.append(S.charAt(S.length()-1)).append(count);
        return sb.length()<S.length()?sb.toString():S;

    }
}
