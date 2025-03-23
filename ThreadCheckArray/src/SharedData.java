import java.util.ArrayList;

/**
 * This class stores shared data, including lists and flags.
 * @author mohamed khattab
 */
public class SharedData {
    
    private ArrayList<Integer> array;
    private boolean [] winArray;
    private boolean flag;
    private final int b;

    /**
     * Constructs a SharedData object with an integer list and a constant value.
     * 
     * @param array a list of integers
     * @param b a constant value
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = array;
        this.b = b;
    }

    /**
     * Returns the boolean array representing wins.
     * 
     * @return a boolean array of wins
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Sets the win array.
     * 
     * @param winArray a new boolean array
     */
    public void setWinArray(boolean [] winArray) {
        this.winArray = winArray;
    }

    /**
     * Returns the list of integers.
     * 
     * @return a list of integers
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

    /**
     * Returns the constant value b.
     * 
     * @return the constant value b
     */
    public int getB() {
        return b;
    }

    /**
     * Returns the flag value.
     * 
     * @return true if the flag is set, otherwise false
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Sets the flag value.
     * 
     * @param flag the new flag value
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}