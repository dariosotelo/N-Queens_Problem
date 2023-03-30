/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package n.queen_problem;

/**
 *
 * @author darios
 */
public class NQueen_Problem {
    private int[] queens;
    private int nqueens;
    
    
    public NQueen_Problem(int nqueens){
        this.nqueens=nqueens;
        this.queens=new int[nqueens];
    }
    
    //The first method will be used to print the solution.
    private void printSolution() {
        //This will create a square matrix, where the places of the queens will be a Q
        //and the places where there are not queens, there will be a #
        for (int i=0; i<nqueens; i++){
            for (int j=0; j<nqueens; j++){
                if (queens[i]==j) 
                    System.out.print("Q ");
                else
                    System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void solve(){
        //This code is to initialize the problem
        placeQueen(0);
    }
    
    private void placeQueen(int i) {
        //This case is where all of the rows have been completed
        if (i == nqueens) {
            printSolution();
            return;
        }
        
        //This is the recursive method,
        //it checks all of the possibilities until it finds a
        //valid position to place a queen, it will call the method 
        //greenLight which will return a true statement if the ith position
        //can be used to place a queen.
        for(int j = 0; j<nqueens; j++){
            queens[i]=j;
            if (greenLight(i, j))
                placeQueen(i+1);
        }
    }
    
    /*
    private boolean greenLight(int i) {
        for (int j=0; j<i; j++){
            int dif = Math.abs(queens[j]-queens[i]);
            //int aux = Math.abs(queens[j])
            if (dif == 0 || dif == j-i)
                return false;
        }
        return true;
    }
    */
    
    private boolean greenLight(int row, int column){
        for (int i=0; i<row; i++){
            int dif = Math.abs(queens[i]-column);
            if (dif == 0 || dif == row - i)
                return false;
        }
        return true;
    }
    
    

}