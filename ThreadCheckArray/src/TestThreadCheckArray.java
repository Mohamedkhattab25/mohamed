import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TestThreadCheckArray class tests the functionality of the ThreadCheckArray class
 * by creating a shared data object, initializing two threads, and checking if a subset
 * of numbers from an array sums up to a given target.
 *@author khaled habashy
 */
public class TestThreadCheckArray {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Thread thread1, thread2;
<<<<<<< HEAD
            
            // Getting user input for array size
            System.out.println("Enter array size");
            int num  = input.nextInt();
            
            ArrayList<Integer> array = new ArrayList<>();
            System.out.println("Enter numbers for array");
            
            // Populating the array with user input
            for (int index = 0; index < num; index++) 
                array.add(input.nextInt());
            
            // Getting the target number
            System.out.println("Enter number");
            num = input.nextInt();
            
            // Creating a shared data object
            SharedData sd = new SharedData(array, num);
            
            // Initializing and starting two threads
            thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
            thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
            thread1.start();
            thread2.start();
            
            try 
            {
                // Waiting for both threads to finish execution
                thread1.join();
                thread2.join();
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            // Checking if a valid subset was found
            if (!sd.getFlag())
            {
                System.out.println("Sorry");
                return;
            }
            
            // Printing results
            System.out.println("Solution for b : " + sd.getB() + ", n = " + sd.getArray().size());
            System.out.print("I:    ");
            for(int index = 0; index < sd.getArray().size(); index++)
                System.out.print(index + "    ");
            System.out.println();
            
=======
            System.out.println("Enter array size");
            int num  = input.nextInt();
            ArrayList<Integer> array = new ArrayList<>();
            System.out.println("Enter numbers for array");
            
            
            for (int index = 0; index < num; index++) 
                array.add(input.nextInt());
            
            System.out.println("Enter number");
            num = input.nextInt();
            
            SharedData sd = new SharedData(array, num);
            
            thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
            thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
            thread1.start();
            thread2.start();
            try 
            {
                thread1.join();
                thread2.join();
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (!sd.getFlag())
            {
                System.out.println("Sorry");
                return;
            }
            System.out.println("Solution for b : " + sd.getB() + ",n = " + sd.getArray().size());
            System.out.print("I:    ");
            for(int index = 0; index < sd.getArray().size() ; index++)
                System.out.print(index + "    ");
            System.out.println();
>>>>>>> branch 'master' of https://github.com/Mohamedkhattab25/mohamed.git
            System.out.print("A:    ");
            for (int index : sd.getArray())
            {
                System.out.print(index);
                int counter = 5;
                while (true)
                {
                    index = index / 10;
                    counter--;
                    if (index == 0)
                        break;
                }
                for (int i = 0; i < counter; i++)
                    System.out.print(" ");
            }

            System.out.println();
            System.out.print("C:    ");
            for (boolean index : sd.getWinArray())
            {
                if (index)
                    System.out.print("1    ");
                else
                    System.out.print("0    ");    
            }
        }
    }
}
