import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.Random;
public class Driver extends RecursiveTask<Integer>{

    private static int[] arr = new int[50000];
    private final int Threshold = 10;
    private int low;
    private int high;

    public Driver(int []arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }
    
    
   
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        int total = sum(arr);
        System.out.println("Total: "+total);
        
    }
    
    public static int sum(int[] array)throws InterruptedException{ 
        ForkJoinPool master = new ForkJoinPool();
        return master.invoke(new Driver(arr,0,array.length));
    }

    
    protected Integer compute() {
        if((high-low) <=Threshold){
            int total=0;
            for (int i = low; i < high; i++) {
                total+=arr[i];
            }
            return total;
        }
        else{
            int mid = (low+high)/2;
            Driver left = new Driver(arr,low,mid);
            Driver right = new Driver(arr, mid, high);
            invokeAll(left,right);
            return left.join()+right.join();
        }
    }
    
}
