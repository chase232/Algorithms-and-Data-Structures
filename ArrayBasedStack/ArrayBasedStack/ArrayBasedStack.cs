using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArrayBasedStack
{
    /// <summary>
    /// Class:      ArrayBasedStack
    /// Developer:  Chase Dickerson
    /// Date:       10/9/2017
    /// Purpose:    Used to test the Stack class
    /// </summary>
    class ArrayBasedStack
    {
        static void Main(string[] args)
        {
            // Creating new object
            Stack stack = new Stack();

            // Testing for empty stack
            Console.WriteLine("Testing for empty stack: ");
            stack.Pop();
            stack.Peek();

            // Pushing numbers into stack
            stack.Push(5);
            stack.Push(10);
            stack.Push(15);
            stack.Push(20);

            // Testing peek
            object peek = stack.Peek();
            Console.WriteLine("Peek = " + peek);

            Console.WriteLine("Currently in stack: ");
            stack.Test();

            Console.WriteLine("");

            // removing items from stack
            stack.Pop();
            stack.Pop();

            Console.WriteLine("Stack now after two pops: ");
            stack.Test();
            Console.ReadKey();
        }
    }
}
