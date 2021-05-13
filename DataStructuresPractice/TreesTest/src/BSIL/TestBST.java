package BSIL;

import java.util.Scanner;

public class TestBST
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        BST <String>  myTree = new BST <> ();

        int numNodes = -1;
        int option;

        boolean setNodes = false;
        boolean setElements = false;

        String searchKey;
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
            System.out.println("3 - Print Tree Diagram ");
            System.out.println("4 - Print Tree Inorder ");
            System.out.println("5 - Print Tree Preorder ");
            System.out.println("6 - Print Tree Postorder ");
            System.out.println("7 - Print Tree Breadth First ");
            System.out.println("8 - Search ");
            System.out.println("9 - Delete ");
            System.out.println("10 - Delete All");
            System.out.println("11 - Get Height of a Node");

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

                    myTree.deleteAll();

                    System.out.println();
                    System.out.println("How many nodes would you to add to the tree?");
                    System.out.print("Enter here: ");

                    numNodes = scan.nextInt();

                    setNodes = true;
                    break;

                case 2:

                    String element;

                    System.out.println();
                    for (int i = 0; i < numNodes; i++)
                    {
                        System.out.print("Enter node element: ");
                        element = scan.nextLine();
                        myTree.insert(element);
                        System.out.println();
                    }

                    setElements = true;
                    break;

                case 3:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.println("Printing Tree:");
                        myTree.printTree();
                        System.out.println();
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
                        System.out.println("Printing Inorder: ");
                        myTree.inorder();
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 5:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.println("Printing Preorder:");
                        myTree.preorder();
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 6:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.println("Printing Postorder:");
                        myTree.postorder();
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 7:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.println("Printing Breadth First:");
                        myTree.breadthFirst();
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 8:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.print("Please enter what you would like to search for: ");
                        searchKey = scan.nextLine();

                        System.out.println();
                        System.out.println("Search Results: " + myTree.search(searchKey));

                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 9:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.print("Enter node you would like to delete: ");
                        nodeToDelete = scan.nextLine();

                        System.out.println();
                        System.out.println(myTree.delete(nodeToDelete));

                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 10:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        myTree.deleteAll();
                        System.out.println("Tree is deleted!");
                    }
                    else
                    {
                        System.out.println("Please enter Element and Node data!");
                    }
                    break;

                case 11:

                    System.out.println();
                    if (setElements && setNodes)
                    {
                        System.out.println("Max height of tree is: ");
                        System.out.println(myTree.getHeight(myTree.getRoot()));
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
