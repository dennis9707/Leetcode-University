package DataStructure;

import sun.invoke.empty.Empty;

import java.util.Scanner;

public class ArrayQueueDemo {
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;

    public ArrayQueueDemo(int arrMaxSize){
        this.maxSize = arrMaxSize;
        rear = -1;
        front = -1;
        arr = new int[this.maxSize];
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("Queue is Full!");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        front++;
        return arr[front];
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front+1];
    }
    public void showQueue(){
        for(int i=front+1;i<=rear;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueueDemo demo = new ArrayQueueDemo(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("Show Queue");
            System.out.println("Exit Queue");
            System.out.println("Add Queue");
            System.out.println("Get Queue");
            System.out.println("Head Queue");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    demo.showQueue();
                    break;
                case 'a':
                    System.out.println("Add one number");
                    int va = scanner.nextInt();
                    demo.addQueue(va);
                    break;
                case 'g':
                    try{
                        int res = demo.getQueue();
                        System.out.printf("get output is %d\n",res);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'f':
                    try{
                        int res = demo.headQueue();
                        System.out.printf("head output is %d\n",res);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("exit");
                    break;
            }
        }
    }

}
