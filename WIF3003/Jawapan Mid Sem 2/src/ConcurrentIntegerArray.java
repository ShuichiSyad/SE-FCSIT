import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentIntegerArray {

    private final int[] array;
    private final int size;
    private final Lock lock = new ReentrantLock();
        
    public ConcurrentIntegerArray (int size){
        this.size = size;
        array = new int[size];
    }
    
    public int get (int index){
        if (index >= 0 && index < size)
            return array[index];
        else
            return -1;
    }
    
    public int getSize(){
        return size;
    }
    
    public void set(int index, int value) throws InterruptedException{
        lock.lock();
//        if(lock.tryLock(Long.MAX_VALUE, TimeUnit.SECONDS)){
        try{
            array[index] = value;
        } finally{
            lock.unlock();
        }
//    } //trylock
    }    
}