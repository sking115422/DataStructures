// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   2
// IDE:          IntelliJ IDEA

/*
This class define a linked list that stores integer values.
*/

package BSIL;

public class LinkedList_Spencer_King
{

   public Node head, tail;

   //Constructor method to create a list of object with head and tail.
   public LinkedList_Spencer_King()
   {
      head = null;
      tail = null;
   }
  
   //Method to add node to end of list
   public void addLastNode(int data) 
   {
      Node newNode = new Node(data);

      if (tail == null)
         head = tail = newNode;        //Empty list

      else 
      {
         tail.next = newNode;       //Link new node as last node
         tail = tail.next;       //Make tail pointer point to last node
      }

      System.out.println("The last node has been added. ");
   }
  
   //======== Your part to complete for this assignment =========
   
   //Method #1: add first node
   public void addFirstNode(int data)
   {
      Node newNode = new Node(data);

      if (head == null)
         tail = head = newNode;     //Empty list

      else
         {
         newNode.next = head;       //Link new node as first node
         head = newNode;      //Make head pointer points to new first node
         }

      System.out.println("The first node has been added. ");
   }
      
   //Method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      int size = countNodes();      //Call count nodes function to determine current size of the list

      int count = 0;

      Node current = head;       //Current points to first node
      Node temp = head.next;     //Temp points to second node

      if (index < 0)                //If for some reason the user inputs a value less than zero, a new first node will be added.
         addFirstNode(data);

      else if (index >= size )      //If the user input index is greater than the size the list, a new last node will be added.
         addLastNode(data);

      else
      {
         while (count != index)        //This while loop steps through the list and brings current to point to position of index and temp to point to the position after index.
         {
            count = count + 1;
            current = current.next;
            temp = temp.next;
         }

         current.next = new Node(data);      //Add and link a new node after our current index position
         (current.next).next = temp;         //Reassign node stored as temp (1 position after index position) as 2 positions after the index position.

         System.out.println("A node has been added after index position " + index + ".");
      }
   }
      
   //Method #3: remove first node
   public void removeFirstNode()
   {
      int size = countNodes();      //Call count nodes function to determine current size of the list

      if (size == 0)          //Return list is empty is the size of the list is zero
         System.out.print("The list is empty");

      else
      {
      head = head.next;       //Shifts head pointer to node after current head
      if (head == null)       //If head is null tail is set as null also
         tail = null;

      System.out.print("The first node has been removed.");
      }
   }
      
   //Method #4: remove last node
   public void removeLastNode()
   {
      int size = countNodes();      //Call count nodes function to determine current size of the list

      if (size == 0)       //Return list is empty is the size of the list is zero
         System.out.print("The list is empty");

      else if (size == 1)       //One node list
         {
            head = tail = null;
            System.out.print("The last node has been removed.");
         }

      else
         {
            Node current = head;    //Current points to head
            for (int i = 0; i < size - 2; i++)        //Step through list until current point to second to last node
               current = current.next;
            tail = current;      //Make new tail second to last node
            tail.next = null;    // Make old last node null
            System.out.print("The last node has been removed.");
         }
   }
    
   //Method #5: remove node at index
   public void removeAtIndex(int index)
   {
      int size = countNodes();      //Call count nodes function to determine current size of the list

      if (size == 0)       //Return list is empty is the size of the list is zero
         System.out.print("The list is empty");

      else
         {
         if (index < 0 || index >= size)     //If index is out of bounds, user is prompted to reenter
            System.out.print("Invalid index! Please try again.");

         else if (index == 0)       //If index is 0, call remove first node method
            removeFirstNode();

         else if (index == size - 1)      //If index is last in list, then call remove last node method
            removeLastNode();

         else
            {
            Node previous = head;      //Previous points to head

            for (int i = 1; i < index; i++)     //Previous is steps through to one less than index
               previous = previous.next;

            Node current = previous.next;       //Current is set to point at node at index position
            previous.next = current.next;       //Node at position after index is set to current index position

            System.out.print("The node at index position " + index + " has been removed.");
            }
         }
   }

          
   //Method #6: countNodes
   public int countNodes()
   {
      int listSize;
      int count = 0;

      Node current = head;    //Current points to first node

      while (current != null)       //Steps from first node to end of list and counts
      {
         count = count + 1;
         current = current.next;
      }

      listSize = count;

      return listSize;     //Return number counted
   }
   
   //Method #7: printInReverse  (Recursive method)
   public void printInReverse(Node L)
   {
      int size = countNodes();      //Call count nodes function to determine current size of the list

      if (size == 0)       //Return list is empty is the size of the list is zero
         System.out.print("The list is empty");

      else
      {
         if (L == null) return;        //Base statement to terminate recursion
         printInReverse(L.next);       //Function passing itself the next node, but doing it before print out statement so it will print in reverse
         System.out.print(L.data + "   ");
      }
   }   

   //================= End of Your Part ==============

   //Method to print out the list
   public void printList() 
   {
      int size = countNodes();      //Call count nodes function to determine current size of the list

      if (size == 0)       //Return list is empty is the size of the list is zero
         System.out.print("The list is empty");

      else
      {
         Node temp;
         temp = head;
         while (temp != null)
         {
            System.out.print(temp.data + "   ");
            temp = temp.next;
         }
      }
   }
  
   //Class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

