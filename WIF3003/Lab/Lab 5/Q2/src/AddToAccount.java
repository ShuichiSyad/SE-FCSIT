public class AddToAccount implements Runnable{

    private Account account = new Account();
    
    public AddToAccount(Account acc) {
        account = acc;
    }

    @Override
    public void run() {
        account.deposit(1);
        System.out.println("Added 1 ringgit.");     
    }
    
}
