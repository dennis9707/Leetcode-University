package DataStructure;

import java.util.Scanner;

public class CirculArrayQueueDemo {
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;

    public CirculArrayQueueDemo(int arrMaxSize){
        this.maxSize = arrMaxSize;
        rear = 0;
        front = 0;
        arr = new int[this.maxSize];
    }
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("Queue is Full!");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        for(int i=front;i < front + size();i++){
            System.out.println(arr[i%maxSize]);
        }
    }
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front];
    }


    public static void main(String[] args) {
        CirculArrayQueueDemo demo = new CirculArrayQueueDemo(4);
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
