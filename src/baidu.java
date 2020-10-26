import java.util.Scanner;
import java.util.*;
public class baidu {
    public static void jump(int lens,String s){
        int[] array = new int[lens];
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        array[0] = 0;
        map.put(s.charAt(0),0);
        for(int i=1;i<lens;i++){
            char temp = s.charAt(i);
            int mapIndex = -1;
            if(map.containsKey(temp)){
                mapIndex = map.get(temp);
                array[i] = Math.min(array[i-1],mapIndex)+1;
            }
            else{
                map.put(temp,array[i-1] + 1);
                array[i] = array[i-1] + 1;
            }
        }
        for(int i=0;i<lens;i++)

        System.out.println(array[i]);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        jump(n,name);
    }
}
