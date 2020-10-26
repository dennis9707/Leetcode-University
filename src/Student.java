import java.util.ArrayList;
import java.util.List;
import java.io.*;

import java.util.*;

public class Student {
    public static int co(List<Integer> height) {
        int count = 0;
        int len = height.get(0);
        height.remove(0);
        List<Integer> copy = new ArrayList<Integer>(height);
        Collections.sort(copy);
        for(int i=0;i<len;i++){
            int a = height.get(i);
            int b = copy.get(i);
            if(a!=b){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){

        List<Integer> height = new ArrayList<Integer>();
        height.add(5);
        height.add(1);
        height.add(1);
        height.add(3);
        height.add(4);
        height.add(1);
        int result = co(height);
        System.out.print(result);

    }

}

