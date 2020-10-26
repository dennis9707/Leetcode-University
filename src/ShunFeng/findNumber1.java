package ShunFeng;

import java.util.Scanner;

public class findNumber1 {
    static int[] findNumber(int num) {
        int[] result = new int[2];
        int lens = checkNumber(num);
        int low = num - 1;
        int high = num + 1;
        while(low < num && low > 0){
            int l = checkNumber(low);
            if(lens == l){
                result[1] = low;
                break;
            }
            else{
                low--;
            }
        }
        while(high > num){
            int h = checkNumber(high);
            if(lens == h){
                result[0] = high;
                break;
            }
            else{
                high++;
            }
        }
        return result;
    }
    static int checkNumber(int num){
        int lens = 0;
        int number = num;
        while((number | 0 ) != 0){
            if((number & 1) == 1){
                lens++;
            }
            number = number >> 1;
        }

        return lens;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = findNumber(_num);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}
