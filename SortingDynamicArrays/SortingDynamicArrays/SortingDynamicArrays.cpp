// SortingDynamicArrays.cpp : Defines the entry point for the console application.
//
// Program:		SortingDynamicArrays.cpp
// Developer:	Chase Dickerson
// Date:		4/8/2018
// Course:		CSC 140

#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cstddef>

using namespace std;

void sort(int arry[], int size);

int main()
{
	// srand used to generate random numbers
	srand(time(NULL));
	int n;

	cout << "Please enter a number for the number of random integers: \n";
	cin >> n;

	// Creating a dynamic array
	int* arry = new int[n];
	arry = new int[n];

	// for loop used to load array with random integers
	for (int i = 0; i < n; i++)
	{
		arry[i] = rand() % 20;
		cout << arry[i] << " ";
	}

	cout << "\n\n";

	// sorting array
	sort(arry, n);

	cout << "Sorted Array:\n";

	// outputting sorted array
	for (int i = 0; i < n; i++)
	{
		cout << arry[i] << " " ;
	}

	cout << "\n";

	// deleting dynamic array to free memory
	delete[] arry;
    return 0;
}

// Bubble sort used to sort array
void sort(int arry[], int size)
{
	bool needNextPass = true;

	for (int k = 1; k < size && needNextPass; k++)
	{
		needNextPass = false;
		for (int i = 0; i < size - k; i++)
		{
			if (arry[i] > arry[i + 1])
			{
				int temp;
				temp = arry[i];
				arry[i] = arry[i + 1];
				arry[i + 1] = temp;
				needNextPass = true;
			}
		}
	}
}
