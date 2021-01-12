// Program:      RadixSort
// Developer:    Chase Dickerson
// Date:         4/8/2018
// Purpose:      Sorts an array using radix sort method

package radixsort;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chase Dickerson
 */
public class RadixSort 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Used for output of sorted array
        int count = 0;
        
        System.out.println("Radix sort:");
        Random rand = new Random();
        int[] array = new int[1000000];
        
        // Creating random array
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rand.nextInt(1000);
        }
        
        // Finding the number of place values for the largest number
        int values = determineLargestPlaceValue(array);

        System.out.println("Largest Place Value: " + values);
        
        int[] sortedArray = radixSort2(array, values); 
        
        // Outputting the sorted array
        System.out.println("Sorted Array");
        for (int i = 0; i < sortedArray.length; i++)
        {
            if (count < 10)
            {
                System.out.print(sortedArray[i] + " ");
                count++;
            }
            else
            {
                System.out.println(sortedArray[i] + " ");
                count = 0;
            }
        }
    }   
    
    // This method sorts an array using radix sort
    public static int[] radixSort2(int [] array, int numOfPlaces)
    {
        // Creating an array list
        ArrayList<Integer>[] buckets = new ArrayList[10];
        
        // 
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new ArrayList<>();
        }
        
        // Only loops the number of place values for the largest number
        for (int placeValue = 0; placeValue < numOfPlaces; placeValue++)
        {
            // Previoulsy had an original for loop.
            //  NetBeans suggested for each loop and execution time 
            //  was faster
            for (ArrayList<Integer> bucket : buckets) {
                // Clears all elements in the ArrayList
                bucket.clear();
            }
            
            // Place elements from the ArrayList to the Bucket
            for(int i = 0; i < array.length; i++)
            {
                int value = getValue(array[i], placeValue);
                buckets[value].add(array[i]);
            }
            
            // Put bucket elements into arraylist             
            int index = 0;  // Used for list
            
            // Previoulsy had an original for loop.
            //  NetBeans suggested for each loop and execution time 
            //  was faster
            for (ArrayList<Integer> bucket : buckets) {
                for (int j = 0; j < bucket.size(); j++) {
                    array[index++] = bucket.get(j);
                }
            }
        }
        
        return array;
    }
    
    // This method returns the value at the desired position
    public static int getValue(int n, int placeValue)
    {
        int value = 1;
        for(int i = 0; i < placeValue; i++)
        {
            value = value * 10;
        }
        
        value = (n / value) % 10;
        return value;
    }
    
    // This method returns the number of place values for the largest number
    public static int determineLargestPlaceValue(int[] array)
    {
        int largest = array[0];
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > largest)
            {
                largest = array[i];
            }
        }
        
        // Finding number of places using the variable largest
        int values = (int)(Math.floor(Math.log10(largest)) + 1);
        
        return values;
    }
}
