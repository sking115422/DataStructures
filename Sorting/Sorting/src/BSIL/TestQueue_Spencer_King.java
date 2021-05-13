// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   4
// IDE:          IntelliJ IDEA

package BSIL;

/*
The TestQueue_Spencer_King class is designed to test the functionality of the Queue_Spencer_King class. It creates a queue called myQueue and then shows the user
a menu of options to choose from including enqueue, dequeue, return front value, return size of queue, check if queue is empty, and print the queue. The user may
then enter the number corresponding to the task they wish to preform to test the Queue_Spencer_King class. The test program is wrapped in a sentinel loop, and will
continue to take commands until 0 is entered, in which case the program terminates.
*/

import java.util.*;         //Importing java utilities package

public class TestQueue_Spencer_King
{

    public static void main(String[] args)          //Main method
    {

        //User welcome statement

        System.out.println();
        System.out.println("Welcome to the TestQueue program! ");

        //Creating new queue object called my myQueue

        Queue_Spencer_King <Object> myQueue = new Queue_Spencer_King<> ();

        Scanner scan = new Scanner (System.in);     //Importing scanner

        //Declaring switch statement variable

        int option;

        //Do while for sentinel structure

        do
        {

            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters when asked to input their menu option

            try {

                //Options menu and input prompt

                System.out.println();
                System.out.println("----- MAIN MENU -----");
                System.out.println("0 – Exit Program ");
                System.out.println("1 – Enqueue ");
                System.out.println("2 – Dequeue ");
                System.out.println("3 – Front ");
                System.out.println("4 – Size ");
                System.out.println("5 – Is Empty? ");
                System.out.println("6 – Print Queue ");

                System.out.println();
                System.out.print("Please choose from the following menu options: ");

                option = scan.nextInt();        //Options menu and input prompt

                //If statement returns invalid entry to user if number entered is out of range 0 to 6

                if (option < 0 || option > 6)
                {
                    System.out.println();
                    System.out.println("Invalid entry. Please try again with a number (0 to 6)!");
                    continue;
                }

            //Catch statement handles errors and asks user to re-input a correct value

            }catch (Exception e)
            {
                System.out.println();
                System.out.println();
                System.out.println("Invalid entry. Please try again with a number (0 to 6)!");
                option = -1;
            }

            switch (option)
            {

                //Case 0 - Ends program

                case 0:
                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                //Case 1 - Enqueue - Ask for user input and adds it to rear of queue then prints queue before and after

                case 1:
                    System.out.println();
                    System.out.print("Queue before:\t");
                    myQueue.printQueue();

                    System.out.println();
                    System.out.println("Please enter any input: ");

                    scan.nextLine();
                    Object value = scan.nextLine();
                    myQueue.enqueue(value);

                    System.out.print("Queue after:\t");
                    myQueue.printQueue();
                    System.out.println();
                    break;

                //Case 2 - Dequeue - Removes nodes from the front of queue then prints queue before and after

                case 2:
                    System.out.println();
                    System.out.print("Queue Before:\t");
                    myQueue.printQueue();

                    System.out.println();
                    myQueue.dequeue();

                    System.out.print("Queue After:\t");
                    myQueue.printQueue();
                    System.out.println();
                    break;

                //Case 3 - Front - Prints first node value in the queue or prints empty if the queue is empty. Also prints current node values in queue.

                case 3:
                    System.out.println();
                    System.out.print("Current Queue:\t\t");
                    myQueue.printQueue();

                    System.out.println();
                    System.out.print("Front of Queue:\t\t");

                    if (myQueue.front() == null)
                        System.out.print("Queue is empty!");
                    else
                        System.out.print(myQueue.front());

                    System.out.println();
                    break;

                //Case 4 - Size - Prints the current size of the queue and prints the current node values in queue

                case 4:
                    System.out.println();
                    System.out.print("Current Queue:\t\t");
                    myQueue.printQueue();

                    System.out.println();
                    System.out.println("Size of Queue:\t\t" + myQueue.size());
                    break;

                //Case 5 - Is Empty - Checks if queue is empty and print true if it is empty and false if it is not. Also prints the current node values in queue.

                case 5:
                    System.out.println();
                    System.out.print("Current Queue:\t\t");
                    myQueue.printQueue();

                    System.out.println();
                    System.out.println("Queue is Empty:\t\t" + myQueue.isEmpty());
                    break;

                //Case 6 - Print Queue - Prints the current node values in queue

                case 6:
                    System.out.println();
                    System.out.print("Current Queue:\t\t");
                    myQueue.printQueue();
                    System.out.println();
                    break;

            }

            /*
            If statement prevents error of infinite loop caused when user enters a string with a space in it. It absorbs extra input, and allows the user to
            re-enter value.
            */

            if (option == -1)
                scan.next();

        } while (option != 0);      //Ends program if user inputs a zero as choice for switch statement

    }


}
