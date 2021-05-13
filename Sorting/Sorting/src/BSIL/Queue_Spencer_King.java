// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   4
// IDE:          IntelliJ IDEA

package BSIL;

/*
Class Queue_Spencer_King initializes queue objects and allows the following operations to be completed: enqueue, dequeue, return front value, return queue size,
check if the queue is empty, and print queue the values in the queue.
*/

public class Queue_Spencer_King <E>     //Extending object class to be generic
{

    //Declaring variables

    private Node <E> first;         //Generic node
    private Node <E> last;          //Generic node
    private int size;

    //Constructor method

    public Queue_Spencer_King ()
    {
        first = null;
        last = null;
        size = 0;
    }

    //Enqueue method to add nodes to the queue

    public void enqueue (E value)
    {
        Node <E> newNode = new Node <> (value, last);       //Creating generic new node
        Node <E> current;                                   //Declaring generic helper node

        if (size == 0)                  //Assigning initial node in queue to first and last pointers
        {
            first = last = newNode;
            size = 1;
        }
        else                            //Adding additional nodes to the rear of the queue
        {
            current = last;
            last = newNode;
            current.next = last;
            size ++;
        }
    }

    //Dequeue method to remove nodes from the queue

    public void dequeue ()
    {
        Node <E> current;

        if (size == 0)                  //Returning to the user that the queue is empty if size equals 0
        {
            printQueue();
        }
        else if (size == 1)             //Setting first and last to null if last node in queue is removed
        {
            first = last = null;
            size = 0;
        }
        else                            //Removing node from the front of the queue
        {
            current = first;
            first = current.next;
            current.next = null;
            size --;
        }
    }

    //Front method returns null if queue is empty or whatever the first value in the queue is

    public Object front ()
    {
        if (size == 0)
        {
            return null;
        }
        else
        {
            return first.value;
        }
    }

    //Size method returns the current size of the queue

    public int size ()
    {
        return size;
    }

    //Is empty method checks if the queue is empty and return true if it is empty and false if it is not

    public boolean isEmpty ()
    {
        if (size == 0)
            return true;
        else
            return false;
    }

    //Print queue method prints out the current values in the queue from first to last

    public void printQueue ()
    {
        Node <E> current = first;

        if (size == 0)
            System.out.print("Queue is empty!");
        else
        {
            for (int i = 0; i < size; i++ )
            {
                System.out.print(current.value);

                if (i < size - 1 )
                    System.out.print(", ");


                current = current.next;
            }
        }
    }

    //Node class overrides parent class to create nodes with values and pointers

    private static class Node <E>       //Extending object class to be generic
    {
        E value;
        private Node <E> next;

        public Node (E value, Node <E> next)        //Constructor method initializes nodes with value and pointer attributes
        {
            this.value = value;             //Setting constructor value equal to class value
            this.next = next;               //Setting constructor next equal to class next
        }
    }


}
