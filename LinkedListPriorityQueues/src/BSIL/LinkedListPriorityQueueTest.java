package BSIL;

import java.util.Scanner;

public class LinkedListPriorityQueueTest
{

    public static void main(String[] args)
    {

        System.out.println();
        System.out.println("Welcome to the queues with linked list and priority test program! ");

        System.out.println();
        System.out.println("This queue will simulation an ER waiting room.");

        LinkedListPriorityQueue <Object> myQueue = new LinkedListPriorityQueue <> () ;

        Scanner scan = new Scanner (System.in);

        int option;

        do {

            System.out.println();
            System.out.println("----- MAIN MENU -----");
            System.out.println("0 – Exit Program ");
            System.out.println("1 – Enqueue ");
            System.out.println("2 – Dequeue ");
            System.out.println("3 – Size ");
            System.out.println("4 – Front ");
            System.out.println("5 – Print Queue ");

            System.out.println("Please choose from the following menu options: ");

            option = scan.nextInt();

            switch (option)
            {

                case 0:
                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                case 1:
                    System.out.println();
                    myQueue.printQueue();

                    System.out.println();
                    System.out.println("Please enter name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Please enter priority: ");
                    int priority = scan.nextInt();
                    System.out.println("Please enter the medical issue: ");
                    scan.nextLine();
                    String medIssue = scan.nextLine();
                    myQueue.enqueue(name, priority, medIssue);

                    System.out.println();
                    myQueue.printQueue();
                    break;

                case 2:
                    System.out.println();
                    myQueue.printQueue();

                    myQueue.dequeue();

                    System.out.println();
                    myQueue.printQueue();
                    break;

                case 3:
                    System.out.println();
                    System.out.println(myQueue.size());
                    break;

                case 4:
                    System.out.println();
                    System.out.println(myQueue.front().toString());
                    break;

                case 5:
                    myQueue.printQueue();
                    break;

            }

        } while (option != 0);

    }


}
