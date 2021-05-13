package BSIL;

import java.util.Scanner;

public class TestAVLT
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        AVLT myAVLT = new AVLT ();

        int numNodes = -1;
        int option;

        boolean setNodes = false;
        boolean setElements = false;

        String nodeToDelete;

        System.out.println();
        System.out.println("Welcome to the tree tester program!");

        do {

            System.out.println();
            System.out.println("Please choose from the following menu options: ");

            System.out.println("----- MAIN MENU -----");
            System.out.println("0 – Exit Program ");
            System.out.println("1 - Enter/Change Number Nodes ");
            System.out.println("2 - Enter Node Elements ");
            System.out.println("3 - Delete Node ");
            System.out.println("4 - Print All ");

            System.out.println();
            System.out.print("Input menu selection here: ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option)
            {
                case 0:

                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                case 1:

//                    myAVLT.deleteAll();

                    System.out.println();
                    System.out.println("How many nodes would you to add to the tree?");
                    System.out.print("Enter here: ");

                    numNodes = scan.nextInt();

                    setNodes = true;
                    break;

                case 2:

                    int element;

                    System.out.println();
                    for (int i = 0; i < numNodes; i++)
                    {
                        System.out.print("Enter node element: ");
                        element = scan.nextInt();
                        myAVLT.insert(element);
                        System.out.println();
                    }

                    setElements = true;
                    break;

                case 3:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.print("Enter node you would like to delete: ");
                        nodeToDelete = scan.nextLine();

                        System.out.println();
//                        System.out.println(myAVLT.delete(nodeToDelete));

                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 4:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.println("Printing Tree:");
                        myAVLT.printTree();
                        System.out.println();

                        System.out.println("Printing Inorder: ");
                        myAVLT.inorder();
                        System.out.println();

                        System.out.println("Printing Breadth First:");
                        myAVLT.breadthFirst();
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

            }

        } while (option != 0);

    }
}
