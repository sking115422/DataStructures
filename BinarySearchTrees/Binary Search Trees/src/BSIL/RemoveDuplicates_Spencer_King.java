// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   5
// IDE:          IntelliJ IDEA

package BSIL;

import java.io.*;       //Importing all of java input output package
import java.util.*;     //Importing all of java utilities package

/*
Class RemoveDuplicates_Spencer_King is designed to work with interface Tree_Spencer_King, AbstractTree_Spencer_King, and BST_Spencer_King to accepting input from the user via keyboard or text file. It then processes that
data and returns it to the user in the form of a print out to the screen or a text file saved on the C drive of the computer (C:/Spencer_King_Assignment5_IO/Outputs).
*/

public class RemoveDuplicates_Spencer_King
{

    public static void main(String[] args)      //Main method
    {

        //Welcome prompt

        System.out.println();
        System.out.println("Hello! Welcome to the RemoveDuplicates_Spencer_King program.");

        System.out.println();
        System.out.println("This program will remove all duplicate words from a text file or keyboard entered string. ");

        Scanner scan = new Scanner(System.in);      //Creating scanner

        int option;     //Declaring switch statement variable

        //Do while for sentinel structure

        do {

            //Creating BST object
            BST_Spencer_King<String> myTree = new BST_Spencer_King<>();

            //Try catch to handle any errors in menu input (user does not input an integer)
            try
            {

                //Menu prompt
                System.out.println();
                System.out.println("Please select from the following menu options:");

                System.out.println();
                System.out.println("----- MAIN MENU -----");
                System.out.println("0 – Exit Program ");
                System.out.println("1 - Read Input from Text File ");
                System.out.println("2 – Read Input from Keyboard ");

                System.out.println();
                System.out.print("Enter menu selection: ");

                //Reading user input for menu selection
                option = scan.nextInt();

                //If statement will only allow this user to enter integer values from 0 to 2
                if (option < 0 || option > 2)
                {
                    System.out.println();
                    System.out.println("Invalid entry. Please try again with a number (0 to 2)!");
                    continue;
                }

            //If there is exception user will be prompted to try again
            }catch (Exception e)
            {
                System.out.println();
                System.out.println("Invalid entry. Please try again with a number (0 to 2)!");
                option = -1;
            }

            //Switch statement for navigation of menu options
            switch (option)
            {

                //Case 0 - Ends program
                case 0:

                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                //Case 1 - Reads input in the form of a text file and outputs in the form of a text file
                case 1:

                    //Try catch to handle exceptions in case the user types and invalid file address for input file
                    try {

                        //User prompt to enter file address
                        System.out.println();
                        System.out.println("Please enter the directory address of the file you would like to select: ");

                        scan.nextLine();        //Absorbs extra space when switching from reading integer to string

                        String fileAddress = scan.nextLine();       //Reading file address

                        //Creating File object for input file and scanning input file
                        File inFile = new File(fileAddress);
                        Scanner scanFile = new Scanner(inFile);

                        //User prompt to tell where output file will be placed: C:/Spencer_King_Assignment5_IO/Outputs
                        System.out.println();
                        System.out.println("File will be processed and output to the C drive in a folder called Spencer_King_Assignment5_IO (C:/Spencer_King_Assignment5_IO)");

                        //Scanning everything in file
                        String lineScanned = scanFile.next();

                        //While there is something to scan concatenate everything together
                        while (scanFile.hasNext())
                        {
                            lineScanned =  lineScanned.concat(" " + scanFile.next());
                        }

                        //Split string into an array of words with a token of " "
                        String [] words = lineScanned.split(" ");

                        //Creating File object for IO folder and output file
                        File ioFolder = new File("C:/Spencer_King_Assignment5_IO");
                        ioFolder.mkdir();
                        File outFile = new File("C:/Spencer_King_Assignment5_IO/Outputs.txt");

                        //Creating filewriter and printwriter objects to print to output file
                        FileWriter fw = new FileWriter(outFile);
                        PrintWriter pw = new PrintWriter(fw);

                        //Printing text from original file to output file and inserting into BST
                        pw.println();
                        pw.println("Original Text: ");
                        for (int i = 0; i < words.length; i++)
                        {
                            pw.print(words[i] + " ");

                            myTree.insert(words[i]);
                        }

                        //My Test File: /Users/spenc/Desktop/test.txt

                        //Printing processed text header to output file
                        pw.println();
                        pw.println();
                        pw.println("Processed Text: ");

                        //Closing filewriter and printwriter to prevent errors
                        fw.close();
                        pw.close();

                        //Calling inorderText() method from BST_Spencer_King class to traverse BST, remove duplicates, and print in order to output file
                        myTree.inorderText();
                        pw.println();

                        //Closing filewriter and printwriter to prevent errors
                        fw.close();
                        pw.close();

                        break;

                    //Catch directs user to renter the file address if it is invalid
                    }catch (Exception e)
                    {
                        System.out.println();
                        System.out.println("Invalid entry. Please try entering the directory address again!");
                        option = -1;
                        continue;
                    }

                //Case 2 - Reads input from keyboard and prints to user
                case 2:

                    //User prompt to enter on keyboard
                    System.out.println();
                    System.out.println("Please type something you wish to enter on the keyboard: ");

                    //Reading user input
                    scan.nextLine();
                    String keyboardInput = scan.nextLine();

                    //Split user input string into an array of words with a token of " "
                    String [] words = keyboardInput.split(" ");

                    //Printing original text and inserting words into BST
                    System.out.println();
                    System.out.println("Original Text: ");
                    for (int i = 0; i < words.length; i++)
                    {
                        System.out.print(words[i] + " ");

                        myTree.insert(words[i]);
                    }
                    System.out.println();

                    //Calling inorderKeyboard() method from BST_Spencer_King class to print the processed text
                    System.out.println();
                    System.out.println("Processed Text: ");
                    myTree.inorderKeyboard();
                    System.out.println();

                    break;

            }

            //If there is an exception this prevents an infinite loop by accepting extra scanner input
            if (option == -1)
                scan.next();

        //Sentinel loop will continue until user enters 0 for menu choice
        } while (option != 0);

    }


}
