public class Matrix {
    private double[][] matrix;
    private int rowD, colD;

    public Matrix(int rowD, int colD) {
        this.rowD = rowD;
        this.colD = colD;
        matrix = new double[rowD][colD];
        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                matrix[i][j]=2.0;
            }
        }
    }

    public int getRowD() {
        return rowD;
    }

    public int getColD() {
        return colD;
    }

    public double getValue(int i, int j) {
        return matrix[i][j];
    }

    public void setValue(int i, int j, double value) {
        matrix[i][j]=value;
    }
    
    public void display(){
        for (int i = 0; i < rowD; i++) {
            for (int j = 0; j < colD; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    
}
