import java.util.*;
import java.util.stream.IntStream;

public class Solution19 {
    //    public int minimumOperations(String leaves) {
//        int lens = leaves.length();
//        int [][] array = new int[lens][3];
//        array[0][0] = leaves.charAt(0) == 'r' ? 0:1;
//        array[0][1] = Integer.MAX_VALUE;
//        array[0][2] = Integer.MAX_VALUE;
//        for(int i=1;i<lens;i++){
//            int isYellow = leaves.charAt(i)=='y' ? 1:0;
//            int isRed = leaves.charAt(i)=='r' ? 1:0;
//            array[i][0] = array[i-1][0] + isYellow;
//            array[i][1] = Math.min(array[i-1][0],array[i-1][i]) + isRed;
//            array[i][2] = Math.min(array[i-1][1],array[i-1][2]) + isYellow;
//
//        }
//        return array[lens-1][2];
//
//    }
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int indexSum = 0;
        int arrayLens = A.length;
        int sumA = IntStream.of(A).sum();
        int sumB = IntStream.of(B).sum();
        int partA1 = 0;
        int partB1 = 0;
        for(int i=1;i<arrayLens;i++){
            partA1 += A[i-1];
            partB1 += B[i-1];
            int partA2 = sumA - partA1;
            int partB2 = sumB - partB1;
            if(partA1 == partA2 && partA2 == partB1 && partB1 == partB2){
                indexSum++;
            }
        }
        return indexSum;
    }
}
