// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   4
// IDE:          IntelliJ IDEA

package BSIL;

/*
The RadixSort_Spencer_King class is designed to implement and test radix sorting on an array of inputs. The program works by accepting input from the user to define
an array of a certain length with that number of values. Then the array values are sorted into buckets (Q0 to Q9) based on their digit's value. Once sorted, they are
dequeued back into the input array in order from Q0 to Q9 (to allow for smallest to largest sorting). This process is repeated with each digit in the input values
until all of the values end up in bucket Q0 such that the size of Q0 equals the input array length. At this point all of the values in the array should be sorted,
and displayed for the user to see. The program will then ask the user if they wish to rerun with different values. A "Y" will allow them to continue testing and
a "N" will terminate the program.
*/

import java.util.Scanner;       //Importing java utilities package

public class RadixSort_Spencer_King
{

    public static void main(String[] args)      //Main method
    {

        //User welcome statement

        System.out.println();
        System.out.println("Welcome to the RadixSort test program! ");

        Scanner scan = new Scanner(System.in);          //Importing scanner

        //Declaring and initializing sentinel loop terminator, exception handler, array length, and inputs array

        boolean terminate = false;
        boolean exceptionHandler = false;
        int [] inputs;
        int arrayLength;

        //Do while for sentinel structure

        do {

            /*
            If statement prevents error of infinite loop caused when user enters a string with a space in it. It absorbs extra input, and allows the user to
            re-enter value.
            */

            if (exceptionHandler)
                scan.next();

            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters

            try
            {

                //Prompting user to enter array length and reading input

                System.out.println();
                System.out.print("Please enter the number of value to be sorted: ");
                arrayLength = scan.nextInt();

            //Catch statement handles errors and asks user to re-input a correct value

            } catch (Exception e)
            {
                System.out.println();
                System.out.println("Invalid entry. Please try again with a only integer values");
                exceptionHandler = true;
                continue;
            }

            //Creating and initializing user input array

            inputs = new int[arrayLength];

            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters

            try
            {
                //Prompting user to enter test value and storing them in user input array

                System.out.println();
                System.out.print("Please enter " + arrayLength + " integer values: ");

                for (int i = 0; i < inputs.length; i++)
                    inputs[i] = scan.nextInt();

            //Catch statement handles errors and asks user to re-input a correct value

            } catch (Exception e)
            {
                System.out.println();
                System.out.println("Invalid entry. Please try again with a only integer values");
                exceptionHandler = true;
                continue;
            }

            //Resets error handler to false once error has been handled

            exceptionHandler = false;

            //Creating new queues or "buckets" Q0 through Q9

            Queue_Spencer_King<Object> Q0 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q1 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q2 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q3 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q4 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q5 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q6 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q7 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q8 = new Queue_Spencer_King<>();
            Queue_Spencer_King<Object> Q9 = new Queue_Spencer_King<>();

            //Printing out user input array before sorting

            System.out.println();
            System.out.print("Input Array Before Sorting:\t\t");
            for (int i = 0; i < inputs.length; i++) {
                System.out.print(inputs[i]);
                if (i < inputs.length - 1)
                    System.out.print(", ");
            }

            //Declaring and initializing variable for position of digit and boolean to terminate sorting loop once finished

            int position = 0;
            boolean sortingFinished = false;

            //While loop to sort input values into buckets for each digit

            while (!sortingFinished) {

                for (int i = 0; i < inputs.length; i++) {

                    //Calling extractDigits method to exacts digits at a certain position

                    int digit = extractDigit(inputs[i], position);

                    /*
                    Switch statement sorts user inputs from array in respective queues or "buckets" based on digit. Ex) 123 based on position 0 would go in Q3
                    (case 3) because the last digit is a 3.
                    */

                    switch (digit) {

                        case 0:
                            Q0.enqueue(inputs[i]);
                            break;

                        case 1:
                            Q1.enqueue(inputs[i]);
                            break;

                        case 2:
                            Q2.enqueue(inputs[i]);
                            break;

                        case 3:
                            Q3.enqueue(inputs[i]);
                            break;

                        case 4:
                            Q4.enqueue(inputs[i]);
                            break;

                        case 5:
                            Q5.enqueue(inputs[i]);
                            break;

                        case 6:
                            Q6.enqueue(inputs[i]);
                            break;

                        case 7:
                            Q7.enqueue(inputs[i]);
                            break;

                        case 8:
                            Q8.enqueue(inputs[i]);
                            break;

                        case 9:
                            Q9.enqueue(inputs[i]);
                            break;
                    }
                }

                //If statement will terminate loop once all digits have been sorted or when the size of Q0 equals the length of the input array

                if (Q0.size() == inputs.length) {
                    sortingFinished = true;
                    continue;
                }

                //Declaring initializing counter so that we can dequeue the values back into the user input array at the right position.

                int count = 0;

                /*
                Each queue or "bucket" has its own while loop. Each while loop only functions while the queue is not empty. It will store values in the user input
                array and dequeue them until it runs out of values. It will terminate once all values are stored and dequeued then the same process will start
                with the next queue.
                */

                while (!Q0.isEmpty()) {
                    inputs[count] = (int) Q0.front();
                    Q0.dequeue();
                    count++;
                }

                while (!Q1.isEmpty()) {
                    inputs[count] = (int) Q1.front();
                    Q1.dequeue();
                    count++;
                }

                while (!Q2.isEmpty()) {
                    inputs[count] = (int) Q2.front();
                    Q2.dequeue();
                    count++;
                }

                while (!Q3.isEmpty()) {
                    inputs[count] = (int) Q3.front();
                    Q3.dequeue();
                    count++;
                }

                while (!Q4.isEmpty()) {
                    inputs[count] = (int) Q4.front();
                    Q4.dequeue();
                    count++;
                }

                while (!Q5.isEmpty()) {
                    inputs[count] = (int) Q5.front();
                    Q5.dequeue();
                    count++;
                }

                while (!Q6.isEmpty()) {
                    inputs[count] = (int) Q6.front();
                    Q6.dequeue();
                    count++;
                }

                while (!Q7.isEmpty()) {
                    inputs[count] = (int) Q7.front();
                    Q7.dequeue();
                    count++;
                }

                while (!Q8.isEmpty()) {
                    inputs[count] = (int) Q8.front();
                    Q8.dequeue();
                    count++;
                }

                while (!Q9.isEmpty()) {
                    inputs[count] = (int) Q9.front();
                    Q9.dequeue();
                    count++;
                }

                //After each loop the position increments to move to the next greater digit.

                position++;

            }

            //Printing out user input array after sorting

            System.out.println();
            System.out.print("Input Array After Sorting:\t\t");
            for (int i = 0; i < inputs.length; i++) {
                System.out.print(inputs[i]);
                if (i < inputs.length - 1)
                    System.out.print(", ");
            }
            System.out.println();

            //User prompt to ask if they would like to rerun code and reading user input

            System.out.println();
            System.out.println("Do you wish to rerun the code with different inputs? (Y/N)");
            scan.nextLine();
            String userExitString = scan.nextLine();

            //If statement to terminate sentinel loop if user inputs upper or lower case N

            if (userExitString.equalsIgnoreCase("N"))
                terminate = true;

        }while (!terminate);

        //Ending program message

        System.out.println();
        System.out.println("***ENDING PROGRAM*** ");

    }

    //Extract digit method - Takes 2 integer values. The second is used to find the digit at that position of the first value. Then returns digit at that position.

    public static int extractDigit (int integerVal, int position)
    {
        return (int) ((integerVal % Math.pow(10, position + 1)) / (Math.pow(10,position)));
    }


}
