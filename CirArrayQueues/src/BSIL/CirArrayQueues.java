package BSIL;

public class CirArrayQueues
{

    private Object [] queue;
    private int first;
    private int last;
    private int currentSize;

    public CirArrayQueues (int maxSize)
    {
        queue = new Object[maxSize];
        first = -1;
        last = - 1;
        currentSize = 0;
    }

    public void enqueue (String name, int age, String PolAff)
    {
        if (currentSize == 0)
        {
            last = 0;
            first = 0;
            People myPeople = new People(name, age, PolAff);
            queue [0] = myPeople;
            currentSize = 1;
        }
        else if (currentSize > 0 && currentSize < (queue.length))
        {
            People myPeople = new People(name, age, PolAff);
            last = (last + 1) % queue.length;
            queue[last] = myPeople;
            currentSize++;
        }
        else
        {
            System.out.println();
            System.out.println("Queue is full!");
        }
    }

    public void dequeue ()
    {

        if (currentSize == 0)
        {
            System.out.println();
            System.out.println("Queue is empty!");
        }
        else
        {
            first = (first + 1) % queue.length ;
            currentSize--;
        }

    }

    public void printInfo ()
    {

        if (currentSize != 0)
        {
            for (int x = first; x <= last; x++)
                System.out.println(queue [x].toString());
        }
        else
        {
            System.out.println();
            System.out.println("Queue is empty!");
        }


    }

    public int size ()
    {
        return currentSize;
    }

    public Object front ()
    {
        return queue [first];
    }
}
