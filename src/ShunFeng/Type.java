package ShunFeng;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.LinkedList;
public class Type {
    static String Typing(String in) {
        int lens = in.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<lens;i++){
            char c = in.charAt(i);
            if(Character.compare(c,'<')==0){
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else{
                sb.append(c);
            }
        }
        String out = sb.toString();
        return out;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String res = Typing(input);
        System.out.println(res);
    }
}
