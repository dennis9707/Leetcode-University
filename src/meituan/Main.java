package meituan;

import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.Scanner;

public class Main {
//    public int sixDigit(int lower, int higher){
//        int sum = 0;
//        for(int i=lower;i<=higher;i++){
//            int ab = i /10000;
//            int ef = i % 100;
//            int cd =(i /100) - (ab*100);
//            if(ab <10 || cd <10 || ef <10){
//                continue;
//            }
//            HashSet<Integer> ints = new HashSet<Integer>();
//            ints.add(ab/10);
//            ints.add(ab%10);
//            ints.add(cd/10);
//            ints.add(cd%10);
//            ints.add(ef/10);
//            ints.add(ef%10);
//            if(ints.size()<6){
//                continue;
//            }
//            if((ab+cd) == ef){
//                System.out.print(ab);
//                System.out.print(cd);
//                System.out.println(ef);
//                sum++;
//            }
//        }
//        System.out.println(sum);
//        return sum;
//    }
//    public void SubSequence(String main,String sub){
//        int pointer = 0;
//        int sum = 0;
//
//        for(int i = 0;i<sub.length();i++){
//            char current = sub.charAt(i);
//            if (pointer>=main.length()){
//                System.out.print("No");
//
//                return;
//            }
//            for (int j = pointer;j<main.length();j++ ){
//                if (current==main.charAt(j)){
//                    pointer = j+1;
//                    sum += pointer;
//                    break;
//                }
//                if (j==main.length()-1){
//                    System.out.print("No");
//                    return;
//                }
//            }
//        }
//        System.out.println("Yes");
//        System.out.print(sum);
//        return;
//    }
    private static void score(char[][] board, int row,int col,int point, int critiq, String command) {
//        find S
        int x=0;
        int y=0;
        int sumScore = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == 'S'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int comLens = command.length();
        for(int i=0;i<comLens;i++){
            char c = command.charAt(i);
            switch (c){
                case 'W':
                    if((x-1)>=0 && board[x-1][y] != '#'){
                        x = x-1;
                    }
                    break;
                case 'A':
                    if((y-1)>=0 && board[x][y-1] != '#'){
                        y = y-1;
                    }
                    break;
                case 'S':
                    if((x+1)<row && board[x+1][y] != '#'){
                        x = x+1;
                    }
                    break;
                case 'D':
                    if((y+1)<col && board[x][y+1] != '#'){
                        y = y+1;
                    }
                    break;
            }

            if(board[x][y]=='O'){
                sumScore += point;
                board[x][y] = '+';
            }
            if(board[x][y]=='X'){
                sumScore -= critiq;
                board[x][y] = '+';
            }
        }
        System.out.print(sumScore);

    }
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        int point = cin.nextInt();
        int critiq = cin.nextInt();
//        System.out.println(row);
//        System.out.println(col);
//        System.out.println(point);
//        System.out.println(critiq);
        cin.nextLine();
        char[][] board = new char[row][col];
        for(int i=0;i<row;i++){
            String inputString = cin.nextLine();
//            System.out.println("inputString " + inputString);
            for(int j=0;j<col;j++){
                board[i][j] = inputString.charAt(j);
//                System.out.println("board i j" + board[i][j]);
            }
        }
        String command = cin.nextLine();
//        System.out.println("command " + command);
//        System.out.print("board");
//        for(int i = 0; i < row; i++)
//        {
//            for(int j = 0; j < col; j++)
//            {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        Main.score(board,row,col,point,critiq,command);

    }


}
