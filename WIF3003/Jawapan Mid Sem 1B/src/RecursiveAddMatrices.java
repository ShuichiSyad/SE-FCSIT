import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveAddMatrices {

    public static void main(String[] args) {
        //Tested for 3x3 matrix. Can also changed to 1000x1000.
        Matrix A = new Matrix(1000, 1000);
        Matrix B = new Matrix(1000, 1000);
        Matrix C = parallelAddMatrix(A, B);
        System.out.println("A: ");
        A.display();
        System.out.println("B: ");
        B.display();
        System.out.println("C: ");
        C.display();
    }

    public static Matrix parallelAddMatrix(Matrix A, Matrix B) {
        if (A.getRowD() != B.getRowD() || A.getColD() != B.getColD()) {
            return null;
        }

        Matrix result = new Matrix(B.getRowD(), A.getColD());
        RecursiveAction task = new SumTask(A, B, result);
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(task);
        return result;
    }
    
    private static class SumTask extends RecursiveAction{

        private Matrix A, B, C;
        
        public SumTask (Matrix A, Matrix B, Matrix C){
            this.A=A;
            this.B=B;
            this.C=C;
        }

        @Override
        protected void compute() {
            RecursiveAction[] tasks = new RecursiveAction[A.getRowD()];//want to transfer whole collection of task instead of two
            for (int i = 0; i<A.getRowD() ; i++)
                tasks[i] = new AddOneRow(i);
            invokeAll(tasks);
        }
        
        private class AddOneRow extends RecursiveAction {
            int i;
            
            public AddOneRow(int i){
                this.i = i;
            }
            
            @Override
            public void compute(){
               
                for (int j=0 ; j<A.getColD(); j++){
                    C.setValue(i, j, A.getValue(i, j) + B.getValue(i, j));
                }
            }
        }        
    }
}
