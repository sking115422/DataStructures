// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   3
// IDE:          IntelliJ IDEA

/*
This class, TestStack_Spencer_King, is designed to test all of the methods from class Stack_Spencer_King. This class shows the user a menu with all of the methods
as options 0-6, and asks the user to choose the desired operation. This not only gives the user the ability to test all of the methods in the Stack_Spencer_King class,
but also to create and manipulate a stack created with a linked list as they see fit.
*/

package BSIL;

import java.util.Scanner;       //Importing java utility package

public class TestStack_Spencer_King
{


    public static void main(String[] args)      //Main method
    {

        Stack_Spencer_King<Object> myStack = new Stack_Spencer_King<>();      //Create a stack object with generic object parameter to accept multiple data types

        Scanner scan = new Scanner(System.in);       //Creating scanner

        //Welcome prompt

        System.out.println();
        System.out.println("Welcome to the Stack test program!");

        //Declaring variable for switch statement

        int option;

        do       //Do while loop for sentinel structure
        {

            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters when asked to input their menu option

            try {

                //Menu and user input prompt

                System.out.println();
                System.out.println("----- MAIN MENU -----");
                System.out.println("0 – Exit Program ");
                System.out.println("1 – Push ");
                System.out.println("2 – Pop ");
                System.out.println("3 – Top ");
                System.out.println("4 – Size ");
                System.out.println("5 – Is Empty? ");
                System.out.println("6 – Print Stack ");

                System.out.println();
                System.out.print("Please review the menu, and enter the number corresponding to the command you would like to execute: ");

                option = scan.nextInt();        //Reading user input

                //If statement returns invalid entry to user if number entered is out of range 0 to 6

                if (option < 0 || option > 6)
                {
                    System.out.println();
                    System.out.println("Invalid entry! Please enter a number between 0 and 6! ");
                }

            //Catch statement handles errors and asks user to re-input a correct value

            } catch (Exception e)
            {
                System.out.println();
                System.out.println();
                System.out.println("Invalid input! Please try again! ");
                option = 10;        //Setting the option value to 10 ensures that the loop will not terminate and user can re-input a new value
            }

            //Creating switch statement to allow user to choose from all various options

            switch (option)
            {
                //Case 0 - Exit Program

                case 0:
                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                //Case 1 - Push

                case 1:

                    //Try-catch implemented to handle errors cause if user accident enters a string with a space in it

                    try {
                        System.out.println();
                        System.out.println("Testing method Push() ");
                        System.out.print("Stack before alteration:\t\t");
                        myStack.printStack();
                        System.out.println();
                        System.out.print("Please enter value to push onto the stack: ");
                        myStack.Push(scan.next());
                        System.out.print("Stack after alteration:\t\t\t");
                        myStack.printStack();
                        System.out.println();
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println();
                        System.out.println("Invalid entry! Please try again! ");
                    }

                //Case 2 - Pop

                case 2:
                    System.out.println();
                    System.out.println("Testing method Pop() ");
                    System.out.print("Stack before alteration:\t\t");
                    myStack.printStack();
                    System.out.println();
                    myStack.Pop();
                    System.out.print("Stack after alteration:\t\t\t");
                    myStack.printStack();
                    System.out.println();
                    break;

                //Case 3 - Top

                case 3:

                    //Try-catch prevent program from failing if user ask for Top() when then the stack is empty

                    try
                    {
                        System.out.println();
                        System.out.println("Testing method Top() ");
                        System.out.println("Top of Stack:\t\t" + myStack.Top());
                        break;
                    }catch (Exception e)
                    {
                        System.out.println("Top of Stack:\t\tThe stack is empty");
                        continue;
                    }

                //Case 4 - Size

                case 4:
                    System.out.println();
                    System.out.println("Testing method Size() ");
                    System.out.println("Size of Stack:\t\t" + myStack.Size());
                    break;

                //Case 5 - Is Empty?

                case 5:
                    System.out.println();
                    System.out.println("Testing method isEmpty () ");
                    System.out.println("The method is empty:\t\t" + myStack.isEmpty());

                    break;

                //Case 6 - Print Stack

                case 6:
                    System.out.println();
                    System.out.println("Testing method printStack() ");
                    System.out.print("The current stack is:\t\t");
                    myStack.printStack();
                    System.out.println();
                    break;
            }

            //If statement prevents error of infinite loop caused when user enters a string with a space in it. It absorbs extra input, and allows the user to re-enter value.

            if (option == 10)
                scan.next();

        } while (option != 0);        //End program if user inputs a zero as choice for switch statement

    }


}
