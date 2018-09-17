package Project1;

class Matrix extends Thread {
    private int[][] A;
    private int[][] B;
    private int[][] C;
    private int row;
    private int column;
    private int index;

    public Matrix(
            int[][] A,
            int[][] B,
            int[][] C,
            int row,
            int column,
            int index)
    {
        this.A=A;
        this.B=B;
        this.C=C;
        this.row = row;
        this.column = column;
        this.index = index;
    }

    public void run()
    {
        for(int x = 0; x< index; x++){
            C[row][column]+=A[row][x]*B[x][column];
        }
    }
}
