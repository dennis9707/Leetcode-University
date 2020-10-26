package Algorithm;

import java.awt.*;
import java.util.ArrayList;

public class HorseChess {
    private static int X;
    private static int Y;
    private static boolean visited[];
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int col = 1;
        int[][] board = new int[X][Y];
        visited = new boolean[X * Y];
        traversal(board,row-1,col-1,1);

        for(int[] rows : board){
            for(int step: rows){
                System.out.println(step + "\t");
            }
            System.out.println();
        }

    }

    public static void traversal(int[][] board, int row, int column, int step){
        board[row][column] = step;

        visited[row * X + column] = true;
        ArrayList<Point>  ps = next(new Point(column,row));
        while(!ps.isEmpty()){
            Point p = ps.remove(0);
            if(!visited[p.y * X + p.x]){
                traversal(board, p.y, p.x, step + 1);
            }
        }

        if(step < X * Y && !finished){
            board[row][column] = 0;
            visited[row * X + column] = false;
        }else{
            finished = true;
        }

    }
    public static ArrayList<Point> next(Point currentPoint){
        ArrayList<Point> ps = new ArrayList<Point>();

        Point p1 = new Point();
        if((p1.x = currentPoint.x - 2) >= 0 && (p1.y = currentPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }

        if((p1.x = currentPoint.x - 1) >= 0 && (p1.y = currentPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }

        if((p1.x = currentPoint.x + 1) < X && (p1.y = currentPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }

        if((p1.x = currentPoint.x + 1) < X && (p1.y = currentPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = currentPoint.x - 1) >= 0 && (p1.y = currentPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = currentPoint.x - 2) >= 0 && (p1.y = currentPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = currentPoint.x + 2) < X && (p1.y = currentPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = currentPoint.x + 2) < X && (p1.y = currentPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }

        return ps;
    }
}
