import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Class:     	QuickSort.java
// Developer: 	Chase Dickerson
// Date:      	3/14/2019

public class Main {
	
	static int myArray[];
	static String variant;
	static int counter = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Please enter a filename:");
        String fileName = scanner.nextLine();
        //System.out.println(fileName);
        
        System.out.println("Please enter a Quicksort variant:");
        variant = scanner.nextLine();
        //System.out.println(variant);
        
        File inputFile = new File(fileName);
        
		if(fileName.equals("input1.txt") || fileName.equals("input2.txt") || fileName.equals("randomized-10.txt") || fileName.equals("ordered-10.txt")) {
			myArray = new int[10];
            myArray = loadArray(myArray, inputFile);
		} else if(fileName.equals("randomized-100.txt") || fileName.equals("ordered-100.txt")) {
			myArray = new int[100];
			myArray = loadArray(myArray, inputFile);
		} else if(fileName.equals("input3.txt") || fileName.equals("randomized-10000.txt") || fileName.equals("ordered-10000.txt")){
			myArray = new int[10000];
			myArray = loadArray(myArray, inputFile);
		}

		quicksort(myArray, 0, myArray.length - 1);
		//System.out.println(myArray.length);
		System.out.println(Arrays.toString(myArray));
		System.out.println(counter);
	}

	public static int[] loadArray(int[] myArray, File inputFile) throws FileNotFoundException, IOException {
		boolean first = true;
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
            	if(first == false) {
            		myArray[i] = Integer.parseInt(line);
                    i++;
            	}    
            	first = false;
            }
		}
		return myArray;
	}

	private static void quicksort(int[] inputArray, int leftIndex, int rightIndex) {
			if(leftIndex < rightIndex) {
				
				// Finding pivot based off input
				if(variant.equals("first")) {
					// Do nothing, the first element will be used as the pivot
				} else if(variant.equals("median3")) {
					int first = inputArray[leftIndex];
					int last = inputArray[rightIndex];
					int middle = inputArray[(leftIndex + rightIndex)/2];			
					
		            // Putting first, middle, and last in a temp array to help find median
					int[] tempArray = new int[] {first, last, middle};
					Arrays.sort(tempArray);
					int median = tempArray[1];					
					if(median == first) {
						// Do nothing
					}else if(median == last) {
						int temp = inputArray[leftIndex];
						inputArray[leftIndex] = last;
						inputArray[rightIndex] = temp;
					}else if(median == middle) {
						int temp = inputArray[leftIndex];
						inputArray[leftIndex] = middle;
						inputArray[(leftIndex + rightIndex)/2] = temp;
					}
					
				} else if(variant.equals("random")){
					Random rand = new Random(); 
					int randIndex = rand.nextInt((rightIndex - leftIndex) + 1) + leftIndex;
					int temp = inputArray[leftIndex];
					inputArray[leftIndex] = inputArray[randIndex];
					inputArray[randIndex] = temp;
				}
				
				int pivotIndex = partition(inputArray, leftIndex, rightIndex);			
			    quicksort(inputArray, leftIndex, pivotIndex - 1);
			    quicksort(inputArray, pivotIndex + 1, rightIndex);
			} 	
	}

	private static int partition(int[] subArray, int left, int right) {		
		int pivot = subArray[left];
		int i = left + 1;
		for(int j = left + 1; j <= right; j++) {	
			counter++;
			if(subArray[j] <= pivot) {
				int temp = subArray[i];
				subArray[i] = subArray[j];
				subArray[j] = temp;
				i += 1;	
			}
		}
		int temp = subArray[i - 1];
		subArray[i - 1] = subArray[left];
		subArray[left] = temp;
		return i - 1;
	}
}
