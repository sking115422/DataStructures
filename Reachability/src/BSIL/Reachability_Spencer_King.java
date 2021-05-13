// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   7
// IDE:          IntelliJ IDEA

package BSIL;

import java.util.*;         //Importing java utilities package

/*
The Reachability_Spencer_King class is designed to allow the user to input a graph as a binary matrix (up to 5 nodes) and return information about the graph entered. This information includes: integer matrices, reachability
matrix, in-degree of each node, out-degree of each node, number of self-loops, number of path lengths, and number of cycles.
*/

public class Reachability_Spencer_King
{


    public static void main(String[] args)
    {

        //Welcome prompt
        System.out.println();
        System.out.println("Welcome to the Reachability program!");

        Scanner scan = new Scanner(System.in);      //Creating scanner

        //Declaring and initializing necessary variables
        int option = -10;
        int numOfNodes = 5;
        int test = 0;
        boolean graphDataEntered = false;

        //Do while for outer sentinel structure (allows user to change or fix number of nodes)
        do
        {

            //Declaring and initializing variable to skip inner loop if needed
            boolean skip = false;

            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters
            try
            {

                System.out.println();
                System.out.print("Please enter the number of nodes in the graph (number of node must be an integer 5 or less): ");

                numOfNodes = scan.nextInt();

                //If statement returns invalid entry to user if number entered is out of range 0 to 5
                if (numOfNodes < 0 || numOfNodes > 5)
                {
                    System.out.println("\nInvalid entry! Try again!");
                    continue;
                }
            }

            //Catch statement handles errors and tell user entry is invalid
            catch (Exception e)
            {
                System.out.println();
                System.out.println("Invalid entry. Try again!");
                skip = true;
                option = -1;
            }

            //Declaring and initializing a 3D array to hold all integer matrices
            int[][][] A = new int[numOfNodes][numOfNodes][numOfNodes];

            //Do while for inner sentinel structure (allows user to test multiple entries)
            do
            {

                //If statement skips inner loop if there is an error with the nodes entry so user can re-enter value
                if (skip)
                    break;

                //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters when asked to input their menu option
                try
                {
                    System.out.println();
                    System.out.println("**** MAIN MENU ********");
                    System.out.println("0 – Exit Program ");
                    System.out.println("1 – Enter Graph Data ");
                    System.out.println("2 – Print Outputs ");
                    System.out.println("3 – Change Number of Graph Nodes ");

                    System.out.println();
                    System.out.print("Enter Menu Selection Here: ");

                    option = scan.nextInt();

                    //If statement returns invalid entry to user if number entered is out of range 0 to 3
                    if (option < 0 || option > 3)
                    {
                        System.out.println();
                        System.out.println("Invalid entry. Please try again with an integer from 0 to 3!");
                        continue;
                    }
                }

                //Catch statement handles errors and asks user to re-input a correct value
                catch (Exception e)
                {
                    System.out.println();
                    System.out.println("Invalid entry. Please try again with an integer from 0 to 3!");
                    option = -1;
                }

                //Switch statement for menu navigation
                switch (option)
                {

                    //Case 0 - Ends Program
                    case 0:

                        System.out.println();
                        System.out.println("**** ENDING PROGRAM ********");
                        break;

                    //Case 1 - Graph Data Entry
                    case 1:

                        test++;     //increments test and data entry values

                        //Headers
                        System.out.println();
                        System.out.println("------------------------- DATA ENTRY " + test + " -------------------------");

                        System.out.println();
                        System.out.println("**** GRAPH DATA ********");

                        //Variable to make sure that graph data has been entered successfully
                        boolean success = false;

                        //Do while to make sure user successfully enters graph data with no errors
                        do
                        {

                            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters
                            try
                            {
                                System.out.println();
                                System.out.println("...");

                                //Allows user to enter a value for each place in the input matrix
                                for (int i = 0; i < numOfNodes; i++)
                                {
                                    for (int j = 0; j < numOfNodes; j++)
                                    {
                                        System.out.print("Enter A1" + " [" + i + ", " + j + "]: ");
                                        A[0][i][j] = scan.nextInt();
                                    }
                                    System.out.println("...");
                                }

                                //If there are no graph data entries then the user will not be able to produce output data
                                success = true;

                            }

                            //Catch statement handles errors and asks user to re-input a correct value
                            catch (Exception e)
                            {
                                System.out.println();
                                System.out.println("Invalid entry! Please try again with a positive integer.");
                            }

                            //Stops loop from running indefinitely
                            if (!success)
                                scan.nextLine();

                        //While loop continues until graph data entry is successful
                        } while (!success);

                        //Variable that once true allow outputs to be printed
                        graphDataEntered = true;

                        System.out.println();
                        System.out.println("----------------------------------------------------------------");

                        break;

                    //Case 2 - Prints Outputs
                    case 2:

                        System.out.println();
                        System.out.println("------------------------- TEST " + test + " -------------------------");

                        //Outputs will only be printed if graph data has first been entered
                        if (graphDataEntered)
                        {
                            //Headers
                            System.out.println();
                            System.out.println("**** OUTPUTS ********");

                            System.out.println();
                            System.out.println("MATRIX COMPUTATIONS");

                            //Computing and storing all integer matrices
                            int[][][] integerMatrices = computeIntegerMatrices(A);

                            //Printing integer matrices
                            for (int i = 0; i < A.length; i++)
                            {
                                System.out.println();
                                System.out.println("Integer Matrix A" + (i + 1) + ":");
                                print(i, integerMatrices);
                            }

                            //Computing and storing reachability matrix
                            int[][] reachabilityMatrix = computeReachabilityMatrix(integerMatrices);

                            //Printing reachability matrix
                            System.out.println();
                            System.out.println("Reachability Matrix: ");
                            print(reachabilityMatrix);

                            //Header
                            System.out.println();
                            System.out.println("OTHER INFORMATION ");

                            //Computing and storing in-degrees for all nodes
                            int[] columnTotalsIn = computeInDegree(integerMatrices);

                            //Header
                            System.out.println();
                            System.out.println("In-Degrees: ");

                            //Printing in-degrees for all nodes
                            for (int i = 0; i < integerMatrices.length; i++)
                            {
                                System.out.println("Node " + (i + 1) + " in-degree is " + columnTotalsIn[i]);
                            }

                            //Computing and storing out-degrees for all nodes
                            int[] columnTotalsOut = computeOutDegree(integerMatrices);

                            //Header
                            System.out.println();
                            System.out.println("Out-Degrees: ");

                            //Printing out-degrees for all nodes

                            for (int i = 0; i < integerMatrices.length; i++)
                            {
                                System.out.println("Node " + (i + 1) + " out-degree is " + columnTotalsOut[i]);
                            }

                            //Computing and storing number of self-loops
                            int selfLoops = computeNumOfSelfLoops(integerMatrices);

                            //Header and printing out number of self loops
                            System.out.println();
                            System.out.println("Self-Loops: ");
                            System.out.println("Total number of self loops is " + selfLoops);

                            //Computing and storing number of paths of all possible edge lengths
                            int[] matrixTotals = computePathLengths(integerMatrices);

                            //Header
                            System.out.println();
                            System.out.println("Path Lengths: ");

                            //Printing the number of paths of all possible edge lengths
                            for (int i = 0; i < integerMatrices.length; i++)
                            {
                                System.out.print("Total number of paths of length " + (i + 1));

                                if (i == 0)
                                    System.out.print(" edge is ");
                                else
                                    System.out.print(" edges is ");

                                System.out.print(matrixTotals[i]);
                                System.out.println();
                            }

                            System.out.println("Total number of paths of any length 1 to " + integerMatrices.length + " edges is " + matrixTotals[matrixTotals.length - 1]);


                            //Computing and storing number of cycles of all possible edge lengths
                            int[] cycles = computeCycles(integerMatrices);

                            //Header
                            System.out.println();
                            System.out.println("Cycles Lengths: ");

                            //Printing the number of cycles of all possible edge lengths
                            for (int i = 0; i < integerMatrices.length; i++)
                            {
                                System.out.print("Total number of cycles of length " + (i + 1));

                                if (i == 0)
                                    System.out.print(" edge is ");
                                else
                                    System.out.print(" edges is ");

                                System.out.print(cycles[i]);
                                System.out.println();
                            }

                            System.out.println("Total number of cycles of any length 1 to " + integerMatrices.length + " edges is " + cycles[matrixTotals.length - 1]);

                        }

                        //Else gives an error if graph data has not been entered
                        else
                        {
                            System.out.println("ERROR! You have not entered graph data! Please enter graph data! ");
                        }

                        System.out.println();
                        System.out.println("----------------------------------------------------------------");

                        break;

                    //Case 3 - Changes Number of Nodes
                    case 3:

                        System.out.println();
                        System.out.println("**** CHANGE NODES ********");
                        break;

                }

                //If statement prevents error of infinite loop
                if (option == -1)
                    scan.nextLine();

            //Ends inner sentinel loop when 0 or 3 is entered as menu choice (0 ends the loop & 3 allows user to change number of nodes)
            } while (option != 0 && option != 3);

            //If statement prevents error of infinite loop
            if (option == -1)
                scan.nextLine();

        //Ends outer sentinel loop when 0 is entered as menu choice
        }while (option != 0);


    }
    /*
    This method below computes all integer matrices for the given graph size and returns them in a 3 dimensional array. The method below creates up to 5 different integer matrices and "stacks" them on top of one
    another. It can be thought of as each of the individual matrices being stacked together to form a 3D cube. (L x W x D).
    */
    public static int [] [] [] computeIntegerMatrices (int [] [] [] ary)
    {
        for(int i = 1; i < ary.length ; i++)        //To store each of the different integer matrices. This creates the slices of the cube. The depth portion.
        {
            for (int j = 0; j < ary.length; j++)        //To store the rows of the matrix or one side of a square slice of the cube. The Length portion.
            {
                for (int k = 0; k < ary.length; k++)        //To store the columns of the matrix or the other side of a square slice of the cube. The width portion.
                {
                    for (int l = 0; l < ary.length; l++)        //To allow each row to be multiplied by each column
                    {
                         ary[i][j][k] = ary[i][j][k] + (ary[i - 1][j][l] * ary[0][l][k]);       //Preforms matrix multiplication then adds the result to the appropriate place in the product integer matrix
                    }                                                                               //The first integer matrix A1 is always multiplied by the successive integer matrices

                }
            }
        }
        return ary;
    }

    //Same idea as when computing integer matrices in the method above except the same place in each integer matrix is added together (A1 [0,0] + A2 [0,0] + A3 [0,0] + ...)
    public static int [] [] computeReachabilityMatrix (int [] [] [] ary)
    {
        int [] [] sumAry = new int[ary.length][ary.length];

        for(int i = 0; i < ary.length ; i++)
        {
            for (int j = 0; j < ary.length; j++)
            {
                for (int k = 0; k < ary.length; k++)
                {
                    sumAry [j] [k] = sumAry [j] [k] + ary [i] [j] [k];
                }
            }
        }
        return sumAry;      //Now returning only 2D matrix
    }

    //Method below is computing in-degrees by summing all the columns for each node in the original matrix (A1)
    public static int [] computeInDegree (int [] [] [] ary)
    {
        int [] columnTotalsIn = new int [ary.length];
        int sum = 0;

            for (int j = 0; j < ary.length; j++)
            {
                for (int k = 0; k < ary.length; k++)
                {
                    sum = sum + ary[0][k][j];
                }
                columnTotalsIn [j] = sum;
                sum = 0;
            }
        return columnTotalsIn;      //Storing values in and returning a normal array
    }

    //Method below is computing out-degrees by summing all the rows for each node in the original matrix (A1)
    public static int [] computeOutDegree (int [] [] [] ary)
    {
        int [] columnTotalsOut = new int [ary.length];
        int sum = 0;

        for (int j = 0; j < ary.length; j++)
        {
            for (int k = 0; k < ary.length; k++)
            {
                sum = sum + ary[0][j][k];
            }
            columnTotalsOut [j] = sum;
            sum = 0;
        }
        return columnTotalsOut;         //Storing values in and returning a normal array
    }

    //Method below is computing self-loops by incrementing a counter each time the diagonal of the original matrix (A1) is great than zero
    public static int computeNumOfSelfLoops (int [] [] [] ary)
    {
        int selfLoops = 0;

        for (int i = 0; i < ary.length; i++)
        {
            if (ary[0][i][i] > 0)
                selfLoops++;
        }
        return selfLoops;       //Storing and returning occurrences count as an int
    }


    //Method below is computing number of path lengths for each number of edges by summing each value in a particular integer matrix
    public static int [] computePathLengths (int [] [] [] ary)
    {
        int [] matrixTotals = new int [ary.length + 1];
        int sum = 0;

        for (int i = 0; i < ary.length; i++)        //Finds number of path lengths for each number of edges
        {
            for (int j = 0; j < ary.length; j++)
            {
                for (int k = 0; k < ary.length; k++)
                {
                    sum = sum + ary[i][j][k];

                }
            }
            matrixTotals [i] = sum;
            sum = 0;
        }
        for (int j = 0; j < ary.length; j++)        //Finds number of path lengths for all possible number of edges
            sum = sum + matrixTotals [j];

        matrixTotals [ary.length] = sum;

        return matrixTotals;        //Storing values in and returning a normal array
    }

    //Method below is computing number of cycles for each number of edges by summing each diagonal value in a particular integer matrix
    public static int [] computeCycles (int [] [] [] ary)
    {
        int [] cycles = new int[ary.length + 1];

        for (int i = 0; i < ary.length; i++)        //Finds number of cycles for each number of edges
        {
            for (int j = 0; j < ary.length; j++)
            {
               cycles[i] = cycles [i] + ary[i][j][j];
            }
        }
        for (int i = 0; i < ary.length; i++)            //Finds number of cycles for all possible number of edges
            cycles[cycles.length - 1] = cycles[cycles.length - 1] + cycles [i];

        return cycles;          //Storing values in and returning a normal array
    }

    //Print function that prints integer matrices
    public static void print ( int A_number, int [] [] [] ary)
    {
        for (int i = 0; i < ary.length; i++)
        {
            System.out.print("[ ");

            for (int j = 0; j < ary.length; j++)
            {
                System.out.print( ary [A_number] [i] [j]);

                if (j < (ary.length - 1))
                    System.out.print("   ");
            }
            System.out.print(" ]");
            System.out.println();
        }
    }

    //Overloaded print function to prints the reachability matrix
    public static void print ( int [] [] ary)
    {
        for (int i = 0; i < ary.length; i++)
        {
            System.out.print("[ ");

            for (int j = 0; j < ary.length; j++)
            {
                System.out.print( ary [i] [j]);

                if (j < (ary.length - 1))
                    System.out.print("   ");
            }
            System.out.print(" ]");
            System.out.println();
        }
    }


}
