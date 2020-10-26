import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int lens = cin.nextInt();
        System.out.println(lens);
        for(int i=0;i<lens;i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            char[][] charArray= new char[x][y];
            for(int j=0;j<x;j++){
                String aa = cin.nextLine();
                System.out.println(aa);

                String[] b = aa.split("\\s+");
                for(int k=0;k<y;k++){
                    System.out.println(b[k]);
                    charArray[j][k] = b[k].charAt(0);
                }
            }
            for(int a=0;a<charArray.length;a++){
                for(int j=0;j<charArray[0].length;j++){
                    System.out.print(charArray[a][j]);
                }
            }
        }
    }
}