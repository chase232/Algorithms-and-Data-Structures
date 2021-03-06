// LinkedListAssignment.cpp : Defines the entry point for the console application.
//
// Program:		LinkedListAssignment.cpp
// Developer:	Chase Dickerson
// Date:		4/25/2018
// Course:		CSC 140

#include "stdafx.h"
#include <iostream>
using namespace std;

// Class IntLinkedListNode
class IntLinkedListNode
{
public:
	IntLinkedListNode();
	IntLinkedListNode(int data, IntLinkedListNode *next);
	int getData();
	IntLinkedListNode *getNext();
	void setData(int data);
	void setNext(IntLinkedListNode *next);

private:
	int data;
	IntLinkedListNode *next;
};

// Class IntLinkedList
class IntLinkedList
{
public:
	IntLinkedList();
	IntLinkedListNode *getFront();
	IntLinkedListNode *getBack();
	void setFront(IntLinkedListNode *front);
	void setBack(IntLinkedListNode *back);

private:
	IntLinkedListNode *front;
	IntLinkedListNode *back;
};

// main
int main()
{
	// Creating a new instance of IntLinkedList
	IntLinkedList linkedList;

	/*
	Creating 5 nodes and setting their data
	*/
	IntLinkedListNode node1;
	node1.setData(5);

	IntLinkedListNode node2;
	node2.setData(10);
	
	IntLinkedListNode node3;
	node3.setData(15);

	IntLinkedListNode node4;
	node4.setData(20);

	IntLinkedListNode node5;
	node5.setData(25);	

	// Point the nodes to one another
	node1.setNext(&node2);
	node2.setNext(&node3);
	node3.setNext(&node4);
	node4.setNext(&node5);

	// Setting front and back
	linkedList.setFront(&node1);
	linkedList.setFront(&node5);

	// Printing list
	cout << "Linked List: \n";
	cout << node1.getData() << "\n";
	cout << node2.getData() << "\n";
	cout << node3.getData() << "\n";
	cout << node4.getData() << "\n";
	cout << node5.getData() << "\n";


    return 0;
}

/*
Constructors and member functions for IntLinkedListNode class
*/
IntLinkedListNode::IntLinkedListNode() : data(0), next(NULL)
{

}

IntLinkedListNode::IntLinkedListNode(int dat, IntLinkedListNode *nex)
{
	data = dat;
	next = nex;
}

int IntLinkedListNode::getData()
{
	return data;
}

IntLinkedListNode* IntLinkedListNode::getNext()
{
	return next;
}

void IntLinkedListNode::setData(int dat)
{
	data = dat;
}

void IntLinkedListNode::setNext(IntLinkedListNode *nex)
{
	next = nex;
}

/*
Constructors and member functions for IntLinkedList class
*/
IntLinkedList::IntLinkedList() : front(NULL), back(NULL)
{

}

IntLinkedListNode* IntLinkedList::getFront()
{
	return front;
}

IntLinkedListNode* IntLinkedList::getBack()
{
	return back;
}

void IntLinkedList::setFront(IntLinkedListNode* f)
{
	front = f;
}

void IntLinkedList::setBack(IntLinkedListNode* b)
{
	back = b;
}


