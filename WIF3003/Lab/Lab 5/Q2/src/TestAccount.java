import java.util.concurrent.*;
public class TestAccount {
    public static void main(String[] args) {
        Account myAccount = new Account();

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i=0; i<10; i++)
            executor.execute(new AddToAccount(myAccount)); 
        
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        
        System.out.println("The final balance is RM" + myAccount.getBalance());      

    }
    
}
