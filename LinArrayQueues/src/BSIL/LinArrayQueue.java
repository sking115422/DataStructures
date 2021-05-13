

package BSIL;

public class LinArrayQueue
{
    private String [] queue;
    private int rear;
    private int front;
    private int size;

    public LinArrayQueue (int maxSize)
    {

        queue = new String[maxSize];
        rear = -1;
        front = -1;
        size = 0;

    }

    public boolean isEmpty ()
    {

    boolean value = false;

    if (size == 0)
        value = true;

    return value;

    }

    public boolean isFull ()
    {
    boolean value = false;

    if (size == queue.length - 1)
        value = true;

    return value;

    }


    public void enqueue (String element)
    {

        if (!isFull())
        {
            front = 0;
            rear++;
            size++;
            queue [rear] = element;
        }
        else
            System.out.println("Queue is full!");
    }

    public void dequeue ()
    {

        if (!isEmpty())
        {


            for (int x = 1; x <= rear; x++)
            {
                queue[x - 1] = queue[x];
            }

            rear--;
            size--;

        }
        else
        {
            System.out.println("Queue is empty!");
            front = -1;
            rear = -1;
        }

    }


    public int size()
    {
    return size;
    }


    public String front ()
    {
    String temp = "Queue is empty!";
    if (front != -1)
        temp = queue [front];

    return temp;
    }

    public void printQueue ()
    {
        if (!isEmpty())
        {
            System.out.println();
            for (int x = front; x <= rear; x++)
                System.out.print(queue[x] + "   ");
            System.out.println();
        }
        else
        {
            System.out.println();
            System.out.println("Queue is empty!");

        }
    }

}
