using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArrayBasedStack
{
    /// <summary>
    /// Class:      Stack
    /// Developer:  Chase Dickerson
    /// Date:       10/9/2017
    /// Purpose:    Used to implement an array based stack
    /// </summary>
    class Stack
    {
        // Declaring variables
        private int currentSize;
        private int capacity;
        int[] stack = new int[10];

        // Property
        public int Capacity
        {
            get
            {
                return capacity;
            }

            set
            {
                capacity = value;
            }
        }

        //Constructor 
        public Stack()
        {
            Capacity = 10;
            currentSize = -1;
            stack = new int[Capacity];
        }  
        
        // Checks if stack is empty
        public bool isEmpty()
        {
            if (currentSize == -1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        // Adds to stack
        public void Push(int num)
        {
            if (currentSize == (Capacity - 1))
            {
                Console.WriteLine("Stack is full: ");
            }
            else
            {
                stack[++currentSize] = num;
            }
        } 
        
        // Removes from stack
        public object Pop()
        {
            if(isEmpty() == true)
            {
                Console.WriteLine("Stack is empty: ");
                return "Nothing to return";
            }
            else
            {
                return stack[currentSize--];
            }
        }  
        
        // Gets value of whats on top of stack
        public object Peek()
        {
            if (isEmpty() == true)
            {
                Console.WriteLine("Stack is empty: ");
                return "Nothing to return";
            }
            else
            {
                return stack[currentSize];
            }
        }

        // Used to test
        public void Test()
        {
            for (int i = currentSize; i > -1; i--)
            {
                Console.WriteLine("Item " + (i + 1) + ": " + stack[i]);
            }
        }
    }


}
