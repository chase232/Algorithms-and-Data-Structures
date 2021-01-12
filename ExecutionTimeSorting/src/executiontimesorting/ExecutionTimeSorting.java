
// Program:     ExectutionTimeSorting
// Developer:   Chase Dickerson
// Date:        4/8/2018
// Purpose:     This program outputs the exectution time of several sorting methods

package executiontimesorting;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chase Dickerson
 */
public class ExecutionTimeSorting 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        // Outputting the header
        System.out.println("\t\t\t50,000\t\t100,000\t\t150,000\t\t200,000\t\t250,000\t\t300,000");
        System.out.println("\t\t-----------------------------------------------------------" +
                            "------------------------------------------");
         
        // Creating a new random object
        Random rand = new Random();
        
        /*
        All sorting methods have their own nested for loop. The first for loop
            is used to increase the array size. The second for loop assigns 
            random integers to the array and gets the executiontime
        */
        System.out.print("\nBubble Sort:      \t ");
//        for (int i = 0, k = 500; i < 6; i++, k = k + 500)
//        {
//            int[] array = new int[k];
//            for (int j = 0; j < k; j++)
//            {
//                array[j] = rand.nextInt(1000);
//            }
//            long time = bubbleSort(array);
//            System.out.print(" " + time + "   \t");
//        }
        
        System.out.print("\nSelection Sort:      \t ");
//        for (int i = 0, k = 50000; i < 6; i++, k = k + 50000)
//        {
//            double[] array = new double[k];
//            for (int j = 0; j < k; j++)
//            {
//                array[j] = rand.nextInt(1000);
//            }
//            long time = selectionSort(array);
//            System.out.print(" " + time + "   \t\t");
//        }
//        
        Random rand2 = new Random();
        System.out.print("\nRadix Sort:      \t ");
        for (int i = 0, k = 50000; i < 6; i++, k = k + 50000)
        {
            int[] array = new int[k];
            for (int j = 0; j < k; j++)
            {
                array[j] = rand2.nextInt(1000);
            }
            long time = radixSort(array);
            System.out.print(" " + time + "   \t\t");
        }
        
        Random rand3 = new Random();
        System.out.print("\nMerge Sort:      \t ");
        for (int i = 0, k = 50000; i < 6; i++, k = k + 50000)
        {
            int[] array = new int[k];
            for (int j = 0; j < k; j++)
            {
                array[j] = rand3.nextInt(1000);
            }
            long startTime = System.currentTimeMillis();
            mergeSort(array);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            System.out.print(" " + time + "   \t\t");
        }
        
        Random rand4 = new Random();
        System.out.print("\nQuick Sort:      \t ");
        for (int i = 0, k = 50000; i < 6; i++, k = k + 50000)
        {
            int[] array = new int[k];
            for (int j = 0; j < k; j++)
            {
                array[j] = rand4.nextInt(1000);
            }
            long time = quickSort1(array);
            System.out.print(" " + time + "   \t\t");
        }
        
        Random rand5 = new Random();
        System.out.print("\nHeap Sort:      \t ");
        for (int i = 0, k = 50000; i < 6; i++, k = k + 50000)
        {
            int [] array = new int[k];
            for (int j = 0; j < k; j++)
            {
                array[j] = rand5.nextInt(1000);
            }
            long time = heapSort(array);
            System.out.print(" " + time + "   \t\t");
        }
    }
    
//    // This is the bubble sort method
//    public static long bubbleSort(int [] array)
//    {
//        long startTime = System.currentTimeMillis();
//        boolean needNextPass = true;
//
//        for (int k = 1; k < array.length && needNextPass; k++)
//        {
//            needNextPass = false;
//            for (int i = 0; i < array.length - k; i++)
//            {
//                if (array[i] > array[i + 1])
//                {
//                    int temp;
//                    temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                    needNextPass = true;
//                }
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        
//        return (endTime - startTime);
   // }
    
    // This is the selection sort method
    public static long selectionSort(double[] list)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.length - 1; i++) 
        {
            // Find the minimum in the list[i..list.length-1]
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) 
            {
                if (currentMin > list[j]) 
                {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            
                  // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) 
            {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        
        long endTime = System.currentTimeMillis();
        
        return (endTime - startTime);
    }
    
    // This is the radix sort method
    public static long radixSort(int [] array)
    {
        long startTime = System.currentTimeMillis();
        int numOfPlaces = determineLargestPlaceValue(array);
        
        ArrayList<Integer>[] buckets = new ArrayList[10];
        
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new ArrayList<>();
        }
        
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
            
            // Used for list 
            int index = 0;
            
            // Previoulsy had an original for loop.
            //  NetBeans suggested for each loop and execution time 
            //  was faster
            for (ArrayList<Integer> bucket : buckets) {
                for (int j = 0; j < bucket.size(); j++) {
                    array[index++] = bucket.get(j);
                }
            }
        }
        
        long endTime = System.currentTimeMillis();
        
        return endTime - startTime;
    }
    
    // This is the merge sort method
    public static void mergeSort(int [] array)
    {
        if (array.length > 1)
        {
            // Merge sort the first half
            int[] firstHalf = new int[array.length / 2];
            System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = array.length - array.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(array, array.length / 2,
              secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, array);
        }
    }
    
    // This is the quick sort method
    public static long quickSort1(int[] array)
    {
        long startTime = System.currentTimeMillis();
        
        quickSort(array, 0, array.length - 1);
                
        long endTime = System.currentTimeMillis();       
        return (endTime - startTime);
        
    }
    
    // This is the heap sort method
    public static <E extends Comparable> long heapSort(int[] list) 
    {
        long startTime = System.currentTimeMillis();
        
        // Create a Heap of integers
        Heap<Integer> heap = new Heap<>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
          heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
          list[i] = heap.remove();
        
        long endTime = System.currentTimeMillis();
        
        return (endTime - startTime);
    }
    
    // This method returns the value at the desired position for radix sort
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
    
    // This method finds the place value of the largest number for radix sort
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
    
    // This method merges two arrays together for merge sort
    public static void merge(int[] list1, int[] list2, int[] temp)
    {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length)
        {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
    
    // This method is used for quick sort
    private static void quickSort(int[] list, int first, int last)
    {
        if (last > first)
        {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    
        /** Partition the array list[first..last] */
    private static int partition(int[] list, int first, int last)
    {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low)
        {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low)
            {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high])
        {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
        {
            return first;
        }
    }
    

} 