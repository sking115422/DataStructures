// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   2
// IDE:          IntelliJ IDEA

package BSIL;

import java.util.*;        //Importing java utility package

/*
This class, myTest_Spencer_King, is designed to test all of the methods from class LinkList_Spencer_King. This class shows the user a menu with all of the methods
as options 0-9, and asks the user chose the desired operation. This not only gives the user the ability to test all of the methods in the LinkedList class, but also
to create and manipulate a linked list as they see fit.
*/


public class myTest_Spencer_King
{


   public static void main(String[] args)
   {
      LinkedList_Spencer_King myList = new LinkedList_Spencer_King();      //Create a list object

      Scanner scan = new Scanner(System.in);       //Creating scanner

      //Welcome prompt

      System.out.println();
      System.out.println("Welcome to the linked list test program!");

      //Declaring variable for switch statement

      int option;

      do       //Do while loop for sentinel structure
      {

         //Menu and user input prompt

         System.out.println();
         System.out.println("----- MAIN MENU -----");
         System.out.println("0 – Exit Program ");
         System.out.println("1 – Add First Node ");
         System.out.println("2 – Add Last Node ");
         System.out.println("3 – Add At Index ");
         System.out.println("4 – Remove First Node ");
         System.out.println("5 – Remove Last Node ");
         System.out.println("6 – Remove At Index ");
         System.out.println("7 – Print List Size ");
         System.out.println("8 – Print List (Forward) ");
         System.out.println("9 – Print List In Reverse ");

         System.out.println();
         System.out.print("Please review the menu, and enter the number corresponding to the command you would like to execute: ");

         //Reading user input for menu option (0-9)

         option = scan.nextInt();

         //Creating switch statement to allow user to choose from all various options

         switch (option)
         {
            //Case 0 - Exit Program

            case 0:
               System.out.println();
               System.out.println("***ENDING PROGRAM***");
               break;

            //Case 1 - Add First Node

            case 1:
               System.out.println();
               System.out.println("Testing method addFirstNode() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               System.out.print("Please enter a first node value: ");
               myList.addFirstNode(scan.nextInt());
               System.out.print("List after alteration:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 2 - Add Last Node

            case 2:
               System.out.println();
               System.out.println("Testing method addLastNode() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               System.out.print("Please enter a last node value: ");
               myList.addLastNode(scan.nextInt());
               System.out.print("List after alteration:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 3 - Add Node at Index

            case 3:
               System.out.println();
               System.out.println("Testing method addAtIndex() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               System.out.print("Please enter the index position where you would like to add a node: ");
               int indexValue = scan.nextInt();
               System.out.print("Please enter a node value: ");
               int nodeValue = scan.nextInt();
               myList.addAtIndex(indexValue, nodeValue);
               System.out.print("List after alteration:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 4 - Remove First Node

            case 4:
               System.out.println();
               System.out.println("Testing method removeFirstNode() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               myList.removeFirstNode();
               System.out.println();
               System.out.print("List after alteration:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 5 - Remove Last Node

            case 5:
               System.out.println();
               System.out.println("Testing method removeLastNode() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               myList.removeLastNode();
               System.out.println();
               System.out.print("List after alteration:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 6 - Remove Node at Index

            case 6:
               System.out.println();
               System.out.println("Testing method removeAtIndex() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               System.out.print("Please enter the index position where you would like to remove a node: ");
               int indexValue2 = scan.nextInt();
               myList.removeAtIndex(indexValue2);
               System.out.println();
               System.out.print("List after alteration:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 7 - Count Nodes

            case 7:
               System.out.println();
               System.out.println("Testing method countNodes() ");
               System.out.print("The current list is:   ");
               myList.printList();
               System.out.println();
               System.out.print("The current list size is: ");
               System.out.print(myList.countNodes());
               System.out.println();
               break;

            //Case 8 - Print List

            case 8:
               System.out.println();
               System.out.println("Testing method printList() ");
               System.out.print("The current list is:   ");
               myList.printList();
               System.out.println();
               break;

            //Case 9 - Print List in Reverse

            case 9:
               System.out.println();
               System.out.println("Testing method printInReverse() ");
               System.out.print("List before alteration:   ");
               myList.printList();
               System.out.println();
               System.out.print("The current list in reverse is:   ");
               myList.printInReverse(myList.head);
               System.out.println();
               break;
            default:
               System.out.println();
               System.out.println("Invalid Entry. Please enter a value from 0 to 9. ");
         }

      } while (option != 0);        //End program if user inputs a zero as choice for switch statement

   }


}

    
