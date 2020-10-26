import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Umbralla {
    public static int getUmbrellas(int requirement, List<Integer> sizes) {
        // Write your code here
        int max = requirement + 1;
        int length = sizes.size();
        int[] re = new int[requirement+1];
        Arrays.fill(re, max);
        re[0] = 0;
        for (int i = 1; i <= requirement; i++) {
            for (int j = 0; j < sizes.size(); j++) {
                if (sizes.get(j) <= i) {
                    System.out.println();
                    int a = re[i];
                    int b = re[i-sizes.get(j)]+1;
                    re[i] = Math.min(a,b);
                }
            }
        }
        for (int i = 0; i <= requirement; i++) {
            System.out.println(i+" "+re[i]);
        }
        return re[requirement];
        }

    public static void main(String[] args){

        List<Integer> height = new ArrayList<Integer>();
        height.add(2);
        height.add(6);
        height.add(5);

        int result = getUmbrellas(10,height);
        System.out.print(result);

    }

}
