package DataStructure;

import org.omg.CORBA.NO_IMPLEMENT;

class Node{
    public int number;
    public int val;
    public Node next;
    public Node(int number,int data){
        this.number = number;
        this.val = data;
    }
}
public class SingleLinkedList {
    private Node head = new Node(0,0);

    public void add(Node node){
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }
    public void addByNumber(int index, int data){
        Node temp = head;
        boolean flag = false;
        int count = index;
        Node prev = null;
        while(count>0){
            prev = temp;
            temp = temp.next;
            count--;
            if(temp == null && index > 0){
                System.out.printf("Cannot insert at position %d\n",index);
                return;
            }
        }
        Node n = new Node(index, data);
        prev.next = n;
        n.next = temp;
    }
    public void delete(int index){
        Node temp = head;
        boolean flag = false;
        while(temp.next != null){
            if(temp.next.number == index){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }
    }
    public void list(){
        if(head.next == null){
            System.out.println("list is empty");
            return;
        }
        Node temp = head.next;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void reverseLinkedList(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node current = head.next;
        Node prev = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(0,1);
        Node node2 = new Node(1,1);
        Node node3 = new Node(2,2);
        SingleLinkedList sl = new SingleLinkedList();
        sl.add(node1);
        sl.add(node2);
        sl.add(node3);
        sl.list();

    }
}
