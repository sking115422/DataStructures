// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   3
// IDE:          IntelliJ IDEA

/*
This Class, Stack_Spencer_King, is designed to provided the necessary functions to create and manipulated a stack created with a linked list, reverse a given string,
and test strings to see if they are palindromes.
*/

package BSIL;

public class Stack_Spencer_King <E>     //<E> Extends the object and allows different types of inputs (String, object, Integer, etc...)
{

    //Declaring private variables

    private int size;
    private Node <E> top;
    private Node <E> bottom;

    //Getter method for size variable

    public int getSize()
    {
        return size;
    }

    //Setter method for size variable

    public void setSize(int size)
    {
        this.size = size;
    }

    //Constructor method to create objects with attributes: size, top, and bottom

    public Stack_Spencer_King ()
    {
        size = 0;
        top = null;
        bottom = null;
    }

    //Method Push () "pushes" user input onto the stack

    public void Push (E data)
    {
        Node<E> newElement = new Node<>(data, top);    //Creating a new node

        if (top == null)        //If stack is originally empty we add one node, assign top and bottom pointer to it, and adjust size to 1
        {
            top = newElement;
            bottom = newElement;
            size = 1;
        }

        else        //Otherwise we add another node to the top of the stack and increase size by 1
        {
            top.next = newElement;
            top = top.next;
            size++;
        }
    }

    //Method Pop () removes top node of the stack

    public void Pop ()
    {

        if (size == 1)     //If there is one node in the stack we remove it and set both top and bottom pointers to null
        {
            top = bottom = null;
            size = 0;
        }

        /*
        If there is more than one node, a new pointer called current is made and shifted to second to the last node then last node is deleted and current is
        moved to final node. Size is then decreased by one.
        */

        else if (size > 1)
        {
            Node <E> current;
            current = bottom;
            for (int i = 1; i < size - 1; i++)
                current = current.next;
            current.next = null;
            top = current;
            size--;
        }
    }

    //Method popAndReturn() is basically the same as the Pop () method the only difference is it now also returns the value of the node being "popped" off

    public E popAndReturn ()
    {
        if (size == 0) return null;

        else if (size == 1)
        {
            Node <E> temp = top;
            top = bottom = null;
            size = 0;
            return temp.value;
        }

        else
        {
            Node <E> current;
            current = bottom;
            for (int i = 1; i < size - 1; i++)
                current = current.next;
            Node <E> temp = current.next;
            current.next = null;
            top = current;
            size--;
            return temp.value;
        }
    }

    //Method Top() returns the top most value in the stack

    public E Top ()
    {
        return top.value;
    }

    //Method Size () returns the current size of the stack

    public int Size ()
    {
        return size;
    }

    //Method isEmpty () returns true if the stack is empty or false if the stack has nodes

    public boolean isEmpty ()
    {
        return size == 0;
    }

    //Method printStack () prints the values of all the nodes on the stack

    public void printStack ()
    {
        if (size == 0)
            System.out.print("The stack is empty");

        else
        {
            Node <E> current;
            current = bottom;

            for (int i = 0; i < size; i++)
            {
                System.out.print(current.value + "   ");
                current = current.next;
            }
        }
    }

    //Class Node creates nodes as objects

    private static class Node <E>
    {
        //Declaring variables for the class

        E value;       // E allows for the creating of an object that can be filled with data of different types
        private Node<E> next;

        public Node(E value, Node<E> next)      //Constructor method creating nodes with properties value and next
        {
            this.value = value;
            this.next = next;
        }
    }

}


