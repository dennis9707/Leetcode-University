package JianZhi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Solution38 {
    /**
     * 字符串全排列
     *
     * 1. 终止条件： x = len(c) - 1
     * 2. 初始化一个set，用于排除重复字符
     */
    List<String> res = new LinkedList<String>();
    char[] c;
    public String[] permutation(String s){
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);

    }

    private void dfs(int x) {
        if(x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
