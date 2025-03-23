import java.util.ArrayList;

<<<<<<< HEAD
/**
 * The ThreadCheckArray class implements the Runnable interface and is responsible for checking
 * whether a subset of numbers from the shared data array can sum up to a given target value.
 * The process is done recursively and is thread-safe.
 * 
 * @author mohamed khattab
 */
public class ThreadCheckArray implements Runnable {
    /**
     * A flag to indicate if a valid subset has been found.
     */
    private boolean flag;
    
    /**
     * An array indicating which elements of the shared array contribute to the solution.
     */
    private boolean[] winArray;
    
    /**
     * The shared data object containing the array and target value.
     */
    SharedData sd;
    
    /**
     * The array of integers to process.
     */
    ArrayList<Integer> array;
    
    /**
     * The target sum to achieve using elements from the array.
     */
    int b;
    
    /**
     * Constructs a new ThreadCheckArray object.
     * 
     * @param sd The shared data object containing the array and target value.
     */
    public ThreadCheckArray(SharedData sd) {
        this.sd = sd;    
        synchronized (sd) {
            array = sd.getArray();
            b = sd.getB();
        }       
        winArray = new boolean[array.size()];
    }
    
    /**
     * A recursive method to check if a subset of the array sums up to the target value.
     * 
     * @param n The current size of the subset being processed.
     * @param b The remaining target value to achieve.
     */
    void rec(int n, int b) {
        synchronized (sd) {
            if (sd.getFlag())
                return;
        }   
        if (n == 1) {
            if (b == 0 || b == array.get(n-1)) {
                flag = true;
                synchronized (sd) {
                    sd.setFlag(true);
                }           
            }
            if (b == array.get(n-1))
                winArray[n-1] = true;
            return;
        }
        
        rec(n-1, b - array.get(n-1));
        if (flag)
            winArray[n-1] = true;
        synchronized (sd) {
            if (sd.getFlag())
                return;
        }   
        rec(n-1, b);
    }

    /**
     * The run method contains the logic for executing the recursive check and updating 
     * the shared data object.
     */
=======
public class ThreadCheckArray implements Runnable {
    private boolean flag;
    private boolean [] winArray;
    SharedData sd;
    ArrayList<Integer> array;
    int b;
    
    public ThreadCheckArray(SharedData sd) {
        this.sd = sd;    
        synchronized (sd) {
            array = sd.getArray();
            b = sd.getB();
        }       
        winArray = new boolean[array.size()];
    }
    
    void rec(int n, int b) {
        synchronized (sd) {
            if (sd.getFlag())
                return;
        }   
        if (n == 1) {
            if (b == 0 || b == array.get(n-1)) {
                flag = true;
                synchronized (sd) {
                    sd.setFlag(true);
                }           
            }
            if (b == array.get(n-1))
                winArray[n-1] = true;
            return;
        }
        
        rec(n-1, b - array.get(n-1));
        if (flag)
            winArray[n-1] = true;
        synchronized (sd) {
            if (sd.getFlag())
                return;
        }   
        rec(n-1, b);
    }

>>>>>>> branch 'master' of https://github.com/Mohamedkhattab25/mohamed.git
    public void run() {
        if (array.size() != 1) {
            if (Thread.currentThread().getName().equals("thread1"))
                rec(array.size()-1, b - array.get(array.size() - 1));
            else 
                rec(array.size()-1, b);
        }
        if (array.size() == 1) {
            if (b == array.get(0) && !flag) {
                winArray[0] = true;
                flag = true;
                synchronized (sd) {
                    sd.setFlag(true);
                }
            }
        }
        if (flag) {
            if (Thread.currentThread().getName().equals("thread1"))
                winArray[array.size() - 1] = true;
            synchronized (sd) {
                sd.setWinArray(winArray);
            }   
        }
    }
}
