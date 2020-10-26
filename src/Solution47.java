import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> permutation = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(ans,permutation,nums,visited,0);
        System.out.print(ans);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> perm, int[] nums, boolean[] vis,int index){
        if(index==nums.length){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i] || ( nums[i] == nums[i-1] && !vis[i-1])){
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            backtrack(ans,perm,nums,vis,index+1);
            perm.remove(index);
            vis[i] = false;
        }

    }

    public static void main(String[] args) {
        solution46 solution46 = new solution46();
        int[] nums = new int[]{1,1,2};
        solution46.permute(nums);
    }

}
