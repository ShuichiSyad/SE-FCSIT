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
public class CustomerInLine implements Runnable{
    private BankingQueue BQ;
    private int targetNumber;
    
    public CustomerInLine(BankingQueue BQ, int targetNumber) {
        this.BQ = BQ;
        this.targetNumber = targetNumber;
    }

    @Override
    public void run() {
        while (true) {
        if (BQ.getNextInLine() >= targetNumber) {
          break;
        }
      }
      System.out.format("Great, finally #%d was called, now it is my turn\n", targetNumber);
    }
    

}
