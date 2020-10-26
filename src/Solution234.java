import java.util.ArrayList;

public class Solution234 {
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> panlindrome = new ArrayList<Integer>();
        while(head!=null){
            panlindrome.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = panlindrome.size();

        while (front < back){
            if(panlindrome.get(front) != panlindrome.get(back)){
                return false;
            }
        }
        return true;

    }
}