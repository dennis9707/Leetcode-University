import java.util.ArrayList;
import java.util.List;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int roomLength = rooms.size();
        int[] roomArray = new int[roomLength];

        dfs(rooms,0,roomArray);
        for(int i=0;i<roomLength;i++){
            if(roomArray[i]!=1){
                return false;
            }
            System.out.println("array "+i+"is "+roomArray[i]);
        }
        return true;

    }

    public void dfs(List<List<Integer>> rooms, int index, int [] roomArray){
        roomArray[index] = 1;
        List<Integer> keys = rooms.get(index);

        for(int number:keys){
            if(roomArray[number] != 1){
                dfs(rooms,number,roomArray);
            }
        }
        return;
    }

//    public static void main(String[] args) {
//        List<Integer> str1 = new ArrayList<Integer>();
//        List<Integer> str2 = new ArrayList<Integer>();
//        List<Integer> str3 = new ArrayList<Integer>();
//        List<Integer> str4 = new ArrayList<Integer>();
//        str1.add(1);
//        str2.add(2);
//        str3.add(3);
//
//        List<List<Integer>> str = new ArrayList<List<Integer>>();
//        str.add(str1);
//        str.add(str2);
//        str.add(str3);
//        str.add(str4);
//
//        Solution841 so = new Solution841();
//        System.out.println("str is"+str);
//        System.out.println(so.canVisitAllRooms(str));
//
//    }

}
