// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   3
// IDE:          IntelliJ IDEA

/*
This class, TestPalindrome_Spencer_King, is designed to use the methods and constructors from class Stack_Spencer_King to use a stack created with a linked list
to test if a user input string is a palindrome.
*/

package BSIL;

import java.util.Scanner;       //Importing java utility package

public class TestPalindrome_Spencer_King
{


    public static void main(String[] args)
    {

        Stack_Spencer_King<Object> testPalindrome = new Stack_Spencer_King<>();     //Create a stack object with generic object parameter to accept multiple data types

        Scanner scan = new Scanner(System.in);       //Creating scanner

        //Welcome prompt

        System.out.println();
        System.out.println("Welcome to the TestPalindrome with Stack test program!");
        System.out.println();

        //Declaring sentinel variable

        String rerunVariable;

        do       //Do while loop for sentinel structure
        {
            System.out.print("Please enter a string of any length: ");
            String inputString = scan.nextLine();

            //For loop takes each character of the user input string and pushes it onto the stack

            for (int i = 0; i < inputString.length(); i++)
                testPalindrome.Push(inputString.charAt(i));

            //Printing the input string for the user

            System.out.println();
            System.out.print("Input String:\t");
            System.out.print(inputString);

            //Printing the judgement Palindrome or Not Palindrome

            System.out.println();
            System.out.print("Judgment:\t\t");

            String judgmentString = "";

            //For loop pops the stack off and concatenates a new string called judgmentString in reverse order of the input string

            for (int i = 0; i < inputString.length(); i++)
            {
                Object letter = testPalindrome.popAndReturn();
                String letterAsString = letter.toString();
                judgmentString = judgmentString.concat(letterAsString);
            }

            //This if-else statement compares the inputString and judgment string. If they match, "Palindrome" is printed. If not, "Not Palindrome" is printed.

            if (inputString.equalsIgnoreCase(judgmentString))
                System.out.print("Palindrome");
            else
                System.out.print("Not Palindrome");
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
