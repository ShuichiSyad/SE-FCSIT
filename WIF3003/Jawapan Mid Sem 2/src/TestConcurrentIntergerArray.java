public class TestConcurrentIntergerArray implements Runnable {

    private ConcurrentIntegerArray cia;

    public TestConcurrentIntergerArray(ConcurrentIntegerArray cia) {
        this.cia = cia;
    }

    public static void main(String[] args) {
        ConcurrentIntegerArray cia = new ConcurrentIntegerArray(10);
        Runnable task1 = new TestConcurrentIntergerArray(cia);
        Runnable task2 = new TestConcurrentIntergerArray(cia);
        Runnable task3 = new TestConcurrentIntergerArray(cia);
        Runnable task4 = new TestConcurrentIntergerArray(cia);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        Thread t4 = new Thread(task4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Resulting array: ");
        for (int i = 0; i < cia.getSize(); i++) {
            System.out.print(cia.get(i) + " ");

        }
    }

    public void run() {
        for (int i = 0; i < cia.getSize(); i++) {
            try {
                cia.set(i, cia.get(i) + 1);
            } catch (InterruptedException ex) {}
        }
    }
}