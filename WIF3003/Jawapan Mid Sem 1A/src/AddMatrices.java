import java.util.concurrent.*;
public class AddMatrices {
    private Matrix A, B, C;

    public AddMatrices() {
        //Tested for 3x3 matrix. Can also changed to 1000x1000.
        this.A = new Matrix(3,3);
        this.B = new Matrix(3,3);
        this.C = new Matrix(3,3);
    }
    
    public static void main(String[] args) {
        AddMatrices am = new AddMatrices();
        am.add();
    }
    
    public void add(){
        if(A.getRowD() != B.getRowD() || A.getColD() != B.getColD()){
            return;
        }
        ExecutorService exe = Executors.newCachedThreadPool();
        int row = A.getRowD();
        int col = A.getColD();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                exe.execute(new AddTask(i,j,A,B,C));
            }
        }
        exe.shutdown();
        try {
            exe.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
        System.out.println("A: ");
        A.display();
        System.out.println("B: ");
        B.display();
        System.out.println("C: ");
        C.display();
    }
    
    private class AddTask implements Runnable{

        private int i,j;
        private Matrix A,B,C;

        public AddTask(int row, int col, Matrix A, Matrix B, Matrix C) {
            this.i = row;
            this.j = col;
            this.A = A;
            this.B = B;
            this.C = C;
        }
        
        @Override
        public void run() {
            C.setValue(i, j, (A.getValue(i, j)+B.getValue(i, j)));
        }
        
    }
}
