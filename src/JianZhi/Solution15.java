package JianZhi;

public class Solution15 {
    public static int hammingWeight(int n) {
        int sum = 0;
//        注意这里 n != 0 很关键， 不能写为 n > 0, 因n默认是signed int
        while(n != 0){
            if((n & 1) == 1){
                sum++;
            }
            n >>>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(23));
    }
}
