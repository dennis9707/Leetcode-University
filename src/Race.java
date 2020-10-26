import java.util.Scanner;
import java.util.*;
public class Race {
    ArrayList<ArrayList<Integer>> lists;
    public Race(int n){
        lists = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            lists.add(list);
        }
    }
    public void match(int a, int b){
        ArrayList<Integer> aList = lists.get(a-1);
        ArrayList<Integer> bList = lists.get(b-1);
        aList.add(b);
        for(int i=0;i<bList.size();b++){
            int temp = bList.get(i);
            aList.add(temp);
        }
    }
    public void output(int p,int n){
        int high = 1;
        int low = n;
        for(int i=0;i<n;i++){
            if(i!=p-1){
                ArrayList<Integer> alist = lists.get(i);
                for(int j=0;j<alist.size();j++){
                    if(p == alist.get(j)){
                        high++;
                    };
                }
            }
            else{
                ArrayList<Integer> alist = lists.get(i);
                low -= alist.size();
            }
        }
        if(high == low){
            System.out.println(high);
        }
        else{
            for(int i=high;i<low;i++)
                System.out.println(i);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(n);
        System.out.println(m);
        System.out.println(p);
        Race bd = new Race(n);
        for (int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            bd.match(a,b);
        }
        bd.output(p,n);
    }
}

