// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   3
// IDE:          IntelliJ IDEA

/*
This class, ReverseString_Spencer_King, is designed to use the methods and constructors from class Stack_Spencer_King to use a stack created with a linked list to
reverse all of the words in an individual string.
*/

package BSIL;

import java.util.*;         //Importing java utility package

public class ReverseString_Spencer_King
{

    public static void main(String[] args)      //Main Method
    {

        Stack_Spencer_King<Object> reverseStack = new Stack_Spencer_King<>();     //Create a stack object with generic object parameter to accept multiple data types

        Scanner scan = new Scanner(System.in);       //Creating scanner

        //Welcome prompt

        System.out.println();
        System.out.println("Welcome to the ReverseString with Stack test program!");
        System.out.println();

        //Declaring sentinel variable

        String rerunVariable;

        do       //Do while loop for sentinel structure
        {

            //User prompt and reading user input

            System.out.print("Please enter a string of any length: ");
            String inputString = scan.nextLine();

            //Creating a variable length array to hold each word from user input string

            String[] words = new String[inputString.length()];

            //For loop breaks up each word from input string that is separated by a space into separate strings

            for (int i = 0; i < inputString.length(); i++)
                words = inputString.split(" ", 0);

            //For loop take each word an pushes it onto the stack

            for (int i = 0; i < words.length; i++)
                reverseStack.Push(words[i]);

            //Printing user input string

            System.out.println();
            System.out.print("Input String:\t\t");
            System.out.print(inputString);

            //Printing user input string reversed

            System.out.println();
            System.out.print("Reversed String:\t");

            //Pop each word stored in the stack off and prints it so it is in reverse order

            int size = reverseStack.getSize();      //Getting size from Stack_Spencer_King class
            while (size > 0)
            {
                System.out.print(reverseStack.popAndReturn() + " ");
                size = size - 1;
                reverseStack.setSize(size);     //Setting size in Stack_Spencer_King class
            }
            System.out.println();

            //Prompting user if they would like to rerun. "Y" to rerun and any other key cancels.

            System.out.println();
            System.out.print("Do you wish to test another string? Enter \"Y\" to test or \"N\" to exit program: ");
            rerunVariable = scan.nextLine();
            System.out.println();

        } while ( rerunVariable.equalsIgnoreCase("Y") );        //End program if user inputs anything other than "Y" or "y"

        System.out.println("***ENDING PROGRAM***");

    }


}

