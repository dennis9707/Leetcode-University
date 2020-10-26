package ali;

import java.util.Scanner;

public class Main {
    public static void steak(int x, int y){
        int nominator = 0;
        int denominator = x * y;

        if(y%2==0){
//            2,4,6...
            if(x%2==0){
//                x == 2,4,6
                System.out.println("1/2");
            }else{
                System.out.println("1/2");
            }
        }
        else{
//            y%2 ==1
            if(x%2==0){
                System.out.println("1/2");
            }else{
//                int a = (y-1)/2;
//                int b = (y+1)/2;
//
//                nominator = (((x+1)/2) * ((y-1)/2))+ (((x-1)/2)*((y+1)/2));
//
//                for(int i=1;i<Math.sqrt(Math.min(nominator,denominator));i++){
//                    if((nominator%i==0) && (denominator%i==0)){
//                        nominator = nominator /i;
//                        denominator = denominator/i;
//                    }
//                }
                nominator = (denominator-1)/2;
                System.out.println(nominator+"/"+denominator);

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x,y;
        for(int i = 0; i < n; i++){
                x = sc.nextInt();
                y = sc.nextInt();
                Main.steak(x,y);
        }
    }
}
