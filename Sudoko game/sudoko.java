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


    
}