/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author adib1
 */
public class CallingQueue implements Runnable{

    private BankingQueue BQ;
    
    public CallingQueue(BankingQueue BQ) {
        this.BQ = BQ;
    }

    @Override
    public void run() {
        while (BQ.getNextInLine() <= 10) {
        System.out.format("Calling for the customer #%d\n", BQ.getNextInLine() );
        BQ.incrementNextInLIne();
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    
    
}
