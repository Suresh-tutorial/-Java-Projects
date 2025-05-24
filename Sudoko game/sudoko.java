import java.util.*;
public class sudoko {
    private static final int SIZE=9;// size of the table
    private static final int EMPTY=0; // value for empty space

   public static void main(String[] args) {

    int[][] board= new int [SIZE][SIZE];
    Scanner scan= new Scanner(System.in);
    System.out.println("Enter the Sudoku puzzle (9X9 grid):");
    System.out.println("Enter 0 for empty cells :");
    System.out.println("Enter numbers row by row , separated by spaces:");

    //read Input
    for(int i=0 ;i<SIZE;++i){
        System.out.println("Row " +(i+1)+":");
        String [] row=scan.nextLine().trim().split("\\s+");
        for(int j=0; j<SIZE;++j){
            board[i][j]=Integer.parseInt(row[j]);
        }
    }
    System.out.println("\nInput Sudoku:");
    printBorad(board);
    if(solveSudoku(board)){
        System.out.println("\nSolution:");
        printBoard(board);
    }
    else{
        System.out.println("\nNo Solution exists for this Sudoku Puzzle.");
    }
    scan.close();
    
   }
   public static void printboard(int [][] board){
    for(int i=0;i<SIZE;++i){
        if(i%3==0){
            System.out.println("----------------------");

        }
        for(int j=0;j<SIZE;++j){
            if(j%3==0 || j!=0){
                System.out.print("|");

            }
            System.out.print(board[i][j]+" ");

        }
        System.out.println();
    }
   }
   public static boolean solveSudoku(int [][] board){
    for(int row=0;row<SIZE;++row){
        for(int col=0;col<SIZE; ++col){
            if(board[row][col]==EMPTY){
                for(int num=1;num<=SIZE;++num){
                    if(isValid(board,row,col,num)){
                        board[row][col]=num;
                        //Recursive solve the rest of the board
                        if(solveSudoku(board)){
                            return true;
                        }else{
                            //if the current number doesn't lead a solution , backtrack
                            board[row][col]=EMPTY;

                        }
                    }
                }
                //if no number works, backtrack
                return false;
            }
        }
    }
    // if we've filled the entire board , the puzzle is solved
    return true;
   }
   private static boolean isValid(int[][] board, int row, int col, int num){
    //check row
    for(int j=0; j<SIZE;++j){
        if(board[row][j]==num){
            return false;
        }
    }
    //check column
    for(int i=0;i<SIZE;++i){
        if(borad[i][col]==num){
            return false;
        }
    }
    //check 3x3 box
    int boxRow= row-row%3;
    int boxCol=col-col%3;
    for(int i=boxRow;i<boxRow+3;++i){
        for(int j=boxCol;j<boxCol+3;++j){
            if(board[i][j]==num){
                return false;
            }
        }

    }
    return true;
   }


    
}