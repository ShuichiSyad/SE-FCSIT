package q1;

public class BankingQueue {
    static volatile int nextInLine = 1;
    
    public int getNextInLine() {
        return nextInLine;
    }
    
    public void incrementNextInLIne() {
        nextInLine++;
    }

}
