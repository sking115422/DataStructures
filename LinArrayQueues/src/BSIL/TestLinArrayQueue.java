

package BSIL;

import java.util.Scanner;

public class TestLinArrayQueue
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Please enter the maximum number of queue spaces: ");

        int maxSize = scan.nextInt();

        LinArrayQueue myQueue = new LinArrayQueue(maxSize);

        int option;

        do
        {

            System.out.println();
            System.out.println("----- MAIN MENU -----");
            System.out.println("0 – Exit Program ");
            System.out.println("1 – Enqueue ");
            System.out.println("2 – Dequeue ");
            System.out.println("3 – Size ");
            System.out.println("4 – Front ");
            System.out.println("5 – Print Queue ");

            System.out.print("Please select from the following menu options: ");

            option = scan.nextInt();


            switch (option)
            {

                case 0:
                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                case 1:
                    myQueue.printQueue();
                    System.out.println();
                    System.out.println("Please enter patient name: ");
                    scan.nextLine();
                    String patientName = scan.nextLine();
                    myQueue.enqueue(patientName);
                    myQueue.printQueue();
                    break;

                case 2:
                    myQueue.printQueue();
                    myQueue.dequeue();
                    myQueue.printQueue();
                    break;

                case 3:
                    System.out.println();
                    System.out.println(myQueue.size());
                    break;

                case 4:
                    System.out.println(myQueue.front());
                    break;

                case 5:
                    myQueue.printQueue();
                    break;

            }

        System.out.println();

        }while (option != 0);

    }


}
