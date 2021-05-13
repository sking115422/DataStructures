// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   6
// IDE:          IntelliJ IDEA

package BSIL;

import java.util.*;        //Importing java utilities package

/*
The HashTable_Spencer_King class is designed to test out hash functions and collision resolution when creating hash tables. In the program we are given a set
of 50 keys stored in an array. We take those keys and use a variety of hash functions and resolution methods to store the keys and probe counts in a second 2
dimensional array. There are 4 methods to test out various combinations. HF1 uses the division method with linear probing. HF2 uses the division method with
quadratic probing. HF3 uses the division method and double hashing. HF4 uses the Mid-Squared method and quadratic probing.
*/

public class HashTable_Spencer_King
{


    //Declaring and initializing class wide variables
    private static final int [] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

    private static final int [] [] table = new int[50] [2];

    private static String typeHF;

    private static final int [] printKey = new int [50];
    private static int count = 0;


    public static void main(String[] args)      //Main method
    {

        Scanner scan = new Scanner(System.in);      //Creating scanner

        int option;

        //Welcome prompt
        System.out.println();
        System.out.println("Welcome to the Hash Table generator!");

        //Do while for sentinel structure
        do
        {

            //Setting array of all keys that were unable to be hashed to 0
            Arrays.fill(printKey, 0);

            //Setting array storing keys and probes to 0
            for (int i = 0; i < table.length; i++)
                for (int j = 0; j < 2; j++)
                    table [i] [j] = 0;

            //Try-catch implemented to prevent code from failing if user accidentally enters non-numeric characters when asked to input their menu option
            try
            {
                //Options menu and input prompt
                System.out.println();
                System.out.println("Please select from the following options. ");

                System.out.println();
                System.out.println("----- MAIN MENU -----");
                System.out.println("0 – Exit Program ");
                System.out.println("1 – Run HF1 (Division with Linear Probing) ");
                System.out.println("2 – Run HF2 (Division with Quadratic Probing) ");
                System.out.println("3 – Run HF3 (Division with Double Hashing) ");
                System.out.println("4 – Run HF4 (Student-Designed Function) ");

                System.out.println();
                System.out.print("Enter selection here: ");

                option = scan.nextInt();        //Reading menu selection from user

                //If statement returns invalid entry to user if number entered is out of range 0 to 4
                if (option < 0 || option > 4)
                {
                    System.out.println();
                    System.out.println("Invalid entry. Please try again with a number (0 to 4)!");
                    continue;
                }

            //Catch statement handles errors and asks user to re-input a correct value
            }catch (Exception e)
            {
                System.out.println();
                System.out.println();
                System.out.println("Invalid entry. Please try again with a number (0 to 4)!");
                option = -1;
            }

            switch (option)
            {
                //Case 0 - Ends Program
                case 0:
                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                //Case 1 - Runs HF1 (Division with Linear Probing)
                case 1:

                    //For statement cycles through each key in the table
                    for (int i = 0; i < table.length; i++)
                        HF1(i);

                    typeHF = "HF1";
                    list(sumProbes());
                    break;

                //Case 2 - Run HF2 (Division with Quadratic Probing)
                case 2:

                    //For statement cycles through each key in the table
                    for (int i = 0; i < table.length; i++)
                        HF2(i);

                    typeHF = "HF2";
                    list(sumProbes());
                    break;

                //Case 3 - Run HF3 (Division with Double Hashing)
                case 3:

                    //For statement cycles through each key in the table
                    for (int i = 0; i < table.length; i++)
                        HF3(i);

                    typeHF = "HF3";
                    list(sumProbes());
                    break;

                //Case 4 - Run HF4 (Student-Designed Function) (Mid-squared method and quadratic probing)
                case 4:

                    //For statement cycles through each key in the table
                    for (int i = 0; i < table.length; i++)
                        HF4(i);

                    typeHF = "HF4";
                    list(sumProbes());
                    break;
            }

            /*
            If statement prevents error of infinite loop caused when user enters a string with a space in it. It absorbs extra input, and allows the user to
            re-enter value.
            */

            if (option == -1)
                scan.next();

        }while (option != 0);       //Ends program if user inputs a zero as choice for switch statement

    }


    //List method prints out the table holding the Key and Probes information. Also prints the sum of probes in the table
    public static void list (int sProbes)
    {
        System.out.println();
        System.out.println("Hash table resulted from " + typeHF);

        System.out.println();
        System.out.println("Index   Key   Probes");
        System.out.println("-----------------------");

        for (int i = 0; i < table.length; i++ )
        {
            System.out.print(" ");
            System.out.printf("%-6d %-7d %-7d ", i,table [i] [0], table [i] [1]);
            System.out.println();
        }

        System.out.println("-----------------------");

        System.out.println();
        System.out.println("Sum of probe values = " + sProbes + " probes.");

        //For and if statement print which keys were unable to hash
        for (int a = 0; a < printKey.length; a++)
        {
            if (printKey [a] != 0)
            {
                System.out.println();
                System.out.println("Unable to hash key " + printKey[a] + " to the table.");
            }
        }

    }

    //HF1 (Division with Linear Probing)
    public static void HF1 (int i )
    {
        int probes = 0;

        //Creates hash function
        int H1 = keys[i] % table.length;

        //If statement checks if location generated by hash function in table is occupied. If not, it inserts key and value of 0 for probes
        if (table [H1] [0] == 0)
        {
            table [H1] [0] = keys[i];
            table [H1] [1] = probes;
        }

        //If location is occupied we start collision resolution
        else
        {
            //While statement checks other locations in the table from the first location linearly until an available location is found.
            while ((table [(H1 + probes) % table.length] [0] != 0))
            {
                probes++;
            }

            //Once a location is found key value and probe value are store in a table
            table[(H1 + probes) % table.length][0] = keys[i];
            table[(H1 + probes) % table.length][1] = probes;
        }

    }

    //HF2 (Division with Quadratic Probing)
    public static void HF2 (int i )
    {
        int probes = 0;

        //Creates hash function
        int H2 = keys[i] % table.length;

        //If statement checks if location generated by hash function in table is occupied. If not, it inserts key and value of 0 for probes
        if (table [H2] [0] == 0)
        {
            table [H2] [0] = keys[i];
            table [H2] [1] = probes;
        }
        //If location is occupied we start collision resolution
        else
        {
            //While statement checks other locations in the table from the first location quadratically until an available location is found.
            while (table [(H2 + probes * probes) % table.length] [0] != 0)
            {
                probes++;
            }

            //Once a location is found key value and probe value are store in a table
            table [(H2 +  probes * probes) % table.length] [0] = keys[i];
            table [(H2 +  probes * probes) % table.length] [1] = probes;
        }

    }

    //HF3 (Division with Double Hashing)
    public static void HF3 (int i )
    {
        int probes = 0;

        //Hash function 1
        int H3a = keys [i] % table.length;
        //Hash function 2
        int H3b = (30 - keys[i] % 25);

        //Initializing integrated hash function (H1 + j * H2)
        int H3 = H3a;

        //If statement checks if location generated by hash function "a" in table is occupied. If not, it inserts key and value of 0 for probes
        if (table [H3a] [0] == 0)
        {
            table [H3a] [0] = keys[i];
            table [H3a] [1] = probes;
        }
        //If location is occupied we start collision resolution
        else
        {
            /*
            While statement checks other locations in the table from the first location using double hashing as the increment until an available location is
            found. It also sets the max number of probes to 50 so that we can prevent an infinite loop
            */
            while ((table [H3] [0] != 0) && (probes < table.length ))
            {
                probes++;
                H3 = (H3a + probes * H3b) % keys.length;
            }

            //If statement stores the key values in an array. If 50 probes is reached, this means the value was not hashed
            if (probes == table.length)
            {
                printKey [count] = keys [i];
                count++;
            }

            //If statement so once an empty location is found key value and probe value are stored in table. Keys that cannot be hashed are not stored.
            if (table [H3] [0] == 0)
            {
                table[H3][0] = keys[i];
                table[H3][1] = probes;
            }
        }

    }

    //HF4 (Student-Designed Function) (Mid-squared method and quadratic probing)
    public static void HF4 (int i )
    {
        int probes = 0;

        //Squaring key value
        int H4 = keys[i] * keys[i];
        //Converting squared key value to a string
        String H4string = Integer.toString(H4);

        //Taking the middle 2 characters of the string
        char a = H4string.charAt(4);
        char b = H4string.charAt(5);

        //Concatenating the character back into a string
        H4string = Character.toString(a).concat(Character.toString(b));

        //Converting the middle 2 character string back to an integer value and using mod function to find remainder if needed.
        H4 = Integer.parseInt(H4string) % table.length;

        //If statement checks if location generated by hash function in table is occupied. If not, it inserts key and value of 0 for probes
        if (table [H4] [0] == 0)
        {
            table [H4] [0] = keys[i];
            table [H4] [1] = probes;
        }
        //If location is occupied we start collision resolution
        else
        {
            /*
            While statement checks other locations in the table from the first location quadratically until an available location is found. It also sets the max
            number of probes to 50 so that we can prevent an infinite loop
            */
            while (table [(H4 + probes * probes) % table.length] [0] != 0 && (probes < 50))
            {
                probes++;
            }

            //If statement stores the key values in an array. If 50 probes is reached, this means the value was not hashed
            if (probes == 50)
            {
                printKey [count] = keys [i];
                count++;
            }

            //If statement so once an empty location is found key value and probe value are stored in table. Keys that cannot be hashed are not stored.
            if (table [(H4 + probes * probes) % table.length] [0] == 0)
            {
                table[(H4 + probes * probes) % table.length][0] = keys[i];
                table[(H4 + probes * probes) % table.length][1] = probes;
            }
        }

    }

    //sumProbes method sums all probe counts in the table and returns the value
    public static int sumProbes ( )
    {
        int sProbes = 0;

        for (int i = 0; i < table.length; i++)
        {
            sProbes = sProbes + table [i][1];
        }
        return sProbes;
    }


}
