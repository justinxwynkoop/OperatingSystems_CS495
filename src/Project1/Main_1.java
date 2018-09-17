// Justin Wynkoop
// CS 327
// Project 1
// 2/14/18

package Project1;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args)
    {
        Scanner In = new Scanner(System.in);

        System.out.print("Insert the number of rows in matrix A: ");
        int rowA=In.nextInt();
        System.out.print("Insert the number of columns in matrix A: ");
        int columnA=In.nextInt();
        System.out.print("Insert the number of rows in matrix B: ");
        int rowB=In.nextInt();
        System.out.print("Insert the number of columns in matrix B: ");
        int columnB=In.nextInt();
        if(columnA!=rowB)
        {
            System.out.println("This matrix cannot compile");
            System.exit(-1);
        }
        System.out.println("The matrix result from product will be "+rowA+" x "+columnB+" matrix.");
        System.out.println();
        int[][] A=new int[rowA][columnA];
        int[][] B=new int[rowB][columnB];
        int[][] C=new int[rowA][columnB];
        Matrix[][] thread= new Matrix[rowA][columnB];

        System.out.println("Insert for matrix A:");
        for(int x=0;x<rowA;x++)
        {
            for(int y=0;y<columnA;y++)
            {
                System.out.print(x+","+y+" = ");
                A[x][y]=In.nextInt();
            }
        }
        System.out.println();
        System.out.println("Insert for matrix B:");
        for(int x=0;x<rowB;x++)
        {
            for(int y=0;y<columnB;y++)
            {
                System.out.print(x+","+y+" = ");
                B[x][y]=In.nextInt();
            }
        }
        System.out.println();
        for(int x=0;x<rowA;x++)
        {
            for(int y=0;y<columnB;y++)
            {
                thread[x][y]=new Matrix(A,B,C,x,y,columnA);
                thread[x][y].start();
            }
        }
        for(int x=0;x<rowA;x++)
        {
            for(int y=0;y<columnB;y++)
            {
                try{
                    thread[x][y].join();
                }
                catch(InterruptedException error){}
            }
        }
        System.out.println("The result of this would be:");
        for(int x=0;x<rowA;x++)
        {
            for(int y=0;y<columnB;y++)
            {
                System.out.print(C[x][y]+" ");
            }
            System.out.println();
        }
    }
}
