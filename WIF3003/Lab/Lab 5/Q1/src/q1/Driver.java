package q1;
import java.util.concurrent.*;
public class Driver {
    public static void main(String[] args) {
        BankingQueue BQ = new BankingQueue();
      Runnable cq = new CallingQueue(BQ);
      Runnable cil = new CustomerInLine(BQ, 4);
      Thread t1 = new Thread(cq);
      Thread t2 = new Thread(cil);
      t1.start();
      t2.start();

    }
    
}
