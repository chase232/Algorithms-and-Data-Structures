using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CounterSort
{
    /// <summary>
    /// Class:      CounterSort
    /// Developer:  Chase Dickerson
    /// Date:       9/19/2017
    /// Purpose:    To take an array of numbers, and sort them from lowest to highest
    /// </summary>
    class CounterSortProject
    {
        // Main method containing 4 method calls
        static void Main(string[] args)
        {
            Console.WriteLine("Sorted Arrays: ");
            FirstArray();
            SecondArray();
            ThirdArray();
            FourthArray();

            Console.ReadKey();
        }

        // FirstArray method used to create the first array
        // and outputs the sorted array
        public static void FirstArray()
        {
            int[] firstArray = new int[50];
            for (int i = 0; i < firstArray.Length; i++)
            {
                firstArray[i] = 5;
            }

            int[] sortedArray1 = CounterSort(firstArray);
            string sorted = IsSorted(sortedArray1);
            Console.WriteLine(sorted);
            for (int i = 0; i < sortedArray1.Length; i++)
                Console.WriteLine(sortedArray1[i]);
        }

        // SecondArray method used to create the second array
        // and outputs the sorted array
        public static void SecondArray()
        {
            int[] secondArray = new int[50];
            for (int i = 0; i < secondArray.Length; i++)
            {
                secondArray[i] = i;
            }

            int[] sortedArray2 = CounterSort(secondArray);
            string sorted2 = IsSorted(sortedArray2);
            Console.WriteLine(sorted2);
            for (int i = 0; i < sortedArray2.Length; i++)
                Console.WriteLine(sortedArray2[i]);
        }

        // ThirdArray method used to create the third array
        // and outputs the sorted array
        public static void ThirdArray()
        {
            int[] thirdArray = new int[50];
            for (int i = 49; i > 0; i--)
            {
                thirdArray[i] = i;
            }

            int[] sortedArray3 = CounterSort(thirdArray);
            string sorted3 = IsSorted(sortedArray3);
            Console.WriteLine(sorted3);
            for (int i = 0; i < sortedArray3.Length; i++)
                Console.WriteLine(sortedArray3[i]);
        }

        // FourthArray method used to create the fourth array
        // and outputs the sorted array
        public static void FourthArray()
        {
            Random rand = new Random();
            int[] fourthArray = new int[50];
            for (int i = 0; i < fourthArray.Length; i++)
            {
                fourthArray[i] = rand.Next(0, 50);
            }

            int[] sortedArray4 = CounterSort(fourthArray);
            string sorted4 = IsSorted(sortedArray4);
            Console.WriteLine(sorted4);
            for (int i = 0; i < sortedArray4.Length; i++)
                Console.WriteLine(sortedArray4[i]);
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
        // Returns "Sorted" if the array is correctly sorted
        // and return "Not Sorted" if it is not correctly sorted
        public static string IsSorted(int[] array)
        {
            for (int i = 1; i < array.Length; i++)
            {
                if (array[i - 1] > array[i])
                {
                    return "Not Sorted";
                }
            }
            return "Sorted";
        }
    }
}
