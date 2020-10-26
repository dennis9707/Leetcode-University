import java.util.ArrayList;
import java.lang.Math;

public class Change{

    final String[] strings = {"Fifty Pounds","Twenty Pounds","Ten Pounds","Five Pounds","Two Pounds","One Pound","Fifty Pence",
            "Twenty Pence","Ten Pence","Five Pence","Two Pence","One Pence"};

    final double[] numbers = {50,20,10,5,2,1,0.50,0.20,0.10,0.05,0.02,0.01};

    ArrayList<Integer> changes = new ArrayList<Integer>();
    double change;
    int index;

    public Change(double price,double cash){
        change = cash - price;
        index = 0;
    }

    public int checkSatisfiability(){
        if(change < 0){
            return -1;
        }
        else if(change == 0){
            return 0;
        }
        return 1;
    }


    public double getCoin(){
        //calculate current coing/note
        while((numbers[index] > change) && (index < numbers.length-1) ){
            index++;
        }

        return numbers[index];
    }

    public void calculateChan(){
        while(change != 0){
            double temp = getCoin();
//            System.out.println("temp is "+temp);
//            System.out.println("change is"+change);
            double times = Math.floor(change/temp);
            while(times>0){
                changes.add(index);
                System.out.println("previous change is"+change);
                System.out.println("temp is"+temp);
                change = change - temp;
                change = Math.round(change*100.0) /100.0;
                System.out.println("post change is"+change);
                times--;
            }
        }
    }

    public void printChange(){
        for(int i=0;i<(changes.size()-1);i++){
            System.out.print(strings[changes.get(i)]+", ");
        }
        System.out.print(strings[changes.get(changes.size()-1)]);

    }

//    public static void main(String[] args) {
//        Change change = new Change(11.25,20);
//        int n = change.checkSatisfiability();
//        if(n==-1){
//            System.out.print("ERROR");
//            return;
//        }
//        else if(n==0){
//            return;
//        }
//        change.calculateChan();
//        change.printChange();
//    }


}
