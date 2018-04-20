import java.util.concurrent.atomic.AtomicInteger;
public class Account {
    private AtomicInteger balance = new AtomicInteger(0);
    
    public int getBalance() {
        return balance.get();
    }
    
    public void deposit(int amount) {      
        balance.set(balance.addAndGet(amount));
        System.out.println("The new balance is " + balance);
        try {
            Thread.sleep(5);
        }
        catch (InterruptedException ex) {
        }
     
    }

}
