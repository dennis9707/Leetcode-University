import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
public class Pattern {
    /**
     * Iterate through each line of input.
     */
//    public static void main(String[] args) throws IOException {
//            String line = ";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32";
//            String[] splittedInput = line.split(";");
//            String pattern = splittedInput[0];
//            String blobs = splittedInput[1];
//            Pattern.patternRecognition(pattern, blobs);
//
//    }

    public static void patternRecognition(String pattern, String blobs) {
        // Write your code here. Feel free to create more methods and/or classes
        String[] parts = blobs.split("\\|");
        ArrayList<Integer> results = new ArrayList<Integer>();
        int length = pattern.length();
        for(String part:parts){

            int partLength = part.length();
            if(length == 0){
                results.add(0);
                continue;
            }
            int count = 0;
            int index = 0;
            for(int i=0;i<=partLength-length;i++){
                int tempIndex = part.substring(i).indexOf(pattern);
                if(tempIndex<0){
                    break;
                }
                else if(tempIndex==0){
                    count++;
                }
            }
            results.add(count);
        }
        printList(results);
    }
    public static void printList(ArrayList<Integer> results){
        int sum = 0;
        for(int i=0;i<results.size();i++){
            int temp = results.get(i);
            System.out.print(temp+"|");
            sum += temp;
        }
        System.out.print(sum);
    }
}
