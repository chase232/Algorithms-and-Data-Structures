using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CounterSortRandomTester
{
    /// <summary>
    /// Class:      CounterSortRandomTester
    /// Developer:  Chase Dickerson
    /// Date:       9/26/2017
    /// Purpose:    To test a counter sort method with intense randomization
    /// </summary>
    class CounterSortRandomTester
    {
        
        static void Main(string[] args)
        {
            // Declaring variables
            int count = 0;
            int i = 1;

            // Declaring the tester array that holds 100000
            int[] testerArray = new int[100000];

            // While loop used to iterrate through 1000 times
            while (i <= 1000)
            {
                // Declaring a random object
                Random rand = new Random();

                // For loop used to generate random array of 100000 elements
                for (int j = 0; j < 100000; j++)
                {
                    testerArray[j] = rand.Next(0,200);
                }

                // testing if random testerArray array is sorted
                int[] sorted = CounterSort(testerArray);

                // Varaible used to hold boolean value of true or false
                //      on whether array is sorted or not
                bool test = IsSorted(sorted);

                // Checking if test is true or false
                if (test == false)
                {
                    // Outputs error to user that array is not sorted
                    Console.WriteLine("Error");
                }
                else
                {
                    // Keeps track of variable count for number of correct arrays sorted
                    count = count + 1;
                }
                i++;
            }
            Console.WriteLine("Testing Completed");

            // Testing if count is equal to 1000 (number of arrays created)
            //    Used to see if all arrays were sorted correctly
            if (count == 1000)
            {
                Console.WriteLine("All arrays sorted correctly");
            }
            else
            {
                Console.WriteLine("An error occured in sorting arrays: ");
            }
            Console.ReadKey();
        }
        // Counter SortMethod
        // This method recieves an array of values and returns 
        // the same array but the values are now sorted from
        // smallest number to highest number
        public static int[] CounterSort(int[] array)
        {
            // setting sortedArray to have the same number of values as the passed array
            int[] sortedArray = new int[array.Length];
            int aLength = array.Length;

            // finding the smallest and largest number
            int minNum = array[0];
            int maxNum = array[0];
            for (int i = 1; i < aLength; i++)
            {
                if (array[i] < minNum)
                {
                    minNum = array[i];
                }
                else if (array[i] > maxNum)
                {
                    maxNum = array[i];
                }
            }

            // creating an array of the frequencies
            // array count is used to hold the number of frequincies
            int[] count = new int[maxNum - minNum + 1];

            // for loop used to find the frequincies
            for (int i = 0; i < aLength; i++)
            {
                count[array[i] - minNum] = count[array[i] - minNum] + 1;
            }
            count[0] = count[0] - 1;

            // looping through count array 
            int cLength = count.Length;
            for (int i = 1; i < cLength; i++)
            {
                count[i] = count[i] + count[i - 1];
            }

            // Sorting the array
            for (int i = aLength - 1; i >= 0; i--)
            {
                sortedArray[count[array[i] - minNum]--] = array[i];
            }

            return sortedArray;
        }

        // This method is used to check if the array is sorted or not
        // Returns true if the array is correctly sorted
        // and returns false if it is not correctly sorted
        public static bool IsSorted(int[] array)
        {
            for (int i = 1; i < array.Length; i++)
            {
                if (array[i - 1] > array[i])
                {
                    return false;
                }
            }

            return true;
        }
    }
}
