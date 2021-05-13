package BSIL;

public class LinkedListPriorityQueue <E>
{
    Patient myPatient;

    private Node <E> first;
    private Node <E> last;
    private int size;

    public LinkedListPriorityQueue ()
    {
        first = last = null;
        size = 0;
    }

    public void enqueue (String name, int priority, String medIssue)
    {

        myPatient = new Patient(name, priority, medIssue);

        Node <E> newNode = new Node <> (myPatient,last, priority );
        Node <E> current = first;
        Node <E> temp;
        Node <E> P = first;

        if (first == null)
        {
            first = last = newNode;
            size = 1;
        }
        else if (priority < first.priorityValue)
        {
            current = first;
            first = newNode;
            first.next = current;
            size++;
        }
        else if (last.priorityValue <= priority)
        {
            current = last;
            last = newNode;
            current.next = last;
            size++;
        }
        else
        {
            for (int x = 0; x < size; x++)
            {
                if (priority >= current.priorityValue)
                    P = current;

                current = current.next;
            }

            last = current;

                temp = P.next;
                P.next = newNode;
                newNode.next = temp;

                size++;
        }

    }


    public void dequeue ()
    {
        if (size == 0)
        {
            System.out.println("Queue is empty!");

        }
        else
        {
            Node <E> current = first;
            first = first.next;
            current.next = null;
            size--;

            if (size == 0)
            {
                first = last = null;
            }
        }
    }

    public void printQueue ()
    {
        if (size == 0)
            System.out.println("Queue is empty!");
        else
        {
            Node<E> current = first;

            for (int x = 0; x < size; x++ )
            {
                System.out.println(current.value.toString());
                current = current.next;
            }
        }
    }

    public int size ()
    {
    return size;
    }

    public Object front ()
    {
    if (size != 0)
        return first.value;
    else
        return "Queue is empty!";
    }

    private static class Node <E>
    {

        Object value;
        private Node <E> next;
        private final int priorityValue;

        public Node (Object value, Node <E> next, int priorityValue)
        {
            this.value = value;
            this.next = next;
            this.priorityValue = priorityValue;

        }

    }

}
