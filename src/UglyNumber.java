public class UglyNumber {
    public static int nthUglyNumber(int n) {

        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;i++){
            int temp_2 = dp[a] * 2;
            int temp_3 = dp[b] * 3;
            int temp_5 = dp[c] * 5;
            int value = Math.min(Math.min(temp_2,temp_3),temp_5);
            dp[i] = value;
            if(value == temp_2){
                a++;
            }
            if(value == temp_3){
                b++;
            }
            if(value == temp_5){
                c++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(dp[i]);
        }
        return dp[4];

    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
