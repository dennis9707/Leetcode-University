package DataStructure;

public class SparseArray {
    public static void main(String[] args) {
//        initiate the initial 2d array
//        1 represent white, player 1
//        2 represent black, player 2
        int[][] board = new int[11][11];
        board[1][2] = 1;
        board[2][1] = 2;

        for(int[] row : board){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//        create associate 2d array
        int sum = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(board[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] sparseboard = new int[sum + 1][3];
        sparseboard[0][0] = 11;
        sparseboard[0][1] = 11;
        sparseboard[0][2] = sum;
        int count = 1;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(board[i][j] != 0){
                    sparseboard[count][0] = i;
                    sparseboard[count][1] = j;
                    sparseboard[count][2] = board[i][j];
                    count++;
                }
            }
        }

        System.out.println("Sparse Array");

        for(int i=0;i<sparseboard.length;i++){
            System.out.printf("%d\t%d\t%d\n",sparseboard[i][0],sparseboard[i][1],sparseboard[i][2]);
        }

//        SparseArray to original array
        int[][] originalBoard = new int[sparseboard[0][0]][sparseboard[0][1]];
        for(int i = 1; i < sparseboard.length; i++ ){
            originalBoard[sparseboard[i][0]][sparseboard[i][1]] = sparseboard[i][2];
        }
        System.out.println("original array");

        for(int[] row : originalBoard){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
