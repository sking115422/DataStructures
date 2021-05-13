package BSIL;

import java.util.Scanner;

public class Main
{

    private static int [] [] studentLLHashTable = new int [15][4];

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        int [] [] keys =
        {
                {1234, 11, 21},
                {8013, 12, 22},
                {7356, 13, 23},
                {4312, 14, 24},
                {7321, 15, 25},
                {4321, 16, 26},
                {1000, 17, 27},
                {2333, 18, 28},
                {6321, 19, 29},
                {2312, 110, 210},

        };

        printKeys(keys);

        for (int i = 0; i < keys.length; i++)
        {
            HF1(keys[i] [0], keys[i] [1], keys[i] [2], studentLLHashTable.length);
        }


        System.out.println();
        System.out.println("Index     Key      Probes     Data1      Data2 ");
        for (int i = 0; i < studentLLHashTable.length; i++)
        {
            {
                System.out.printf("%-9d %-8d %-8d %-8d %d",i, studentLLHashTable[i][0], studentLLHashTable[i][1], studentLLHashTable[i][2], studentLLHashTable[i][3] );
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Please enter a value to search for: ");

        int searchValue = scan.nextInt();

        search(searchValue,studentLLHashTable.length);

    }

    public static void printKeys (int [] [] ary)
    {
        System.out.println();
        System.out.println("Keys:");
        for (int i = 0; i < ary.length; i++)
            System.out.println(i + " --> " + ary [i][0] + " --> " + ary [i][1] + " --> " + ary [i][2]);
    }



    public static void HF1 (int key, int data1, int data2, int numKeys)
    {
        int H1 = key % numKeys;
        int probe = 0;

        if (studentLLHashTable [H1] [0] == 0 )
        {
            studentLLHashTable[H1][0] = key;
            studentLLHashTable[H1][1] = probe;
            studentLLHashTable[H1][2] = data1;
            studentLLHashTable[H1][3] = data2;
        }

        else
        {
            do
            {
                probe++;

            } while(studentLLHashTable [H1 + probe] [0] != 0);

            if (studentLLHashTable [H1 + probe] [0] == 0)
            {
                studentLLHashTable[(H1 + probe) % studentLLHashTable.length][0] = key;
                studentLLHashTable[(H1 + probe) % studentLLHashTable.length][1] = probe;
                studentLLHashTable[(H1 + probe) % studentLLHashTable.length][2] = data1;
                studentLLHashTable[(H1 + probe) % studentLLHashTable.length][3] = data2;
            }

        }


    }

    public static void search (int key, int numKeys)
    {
        int probe = 0;
        int H1 = key % numKeys;

        boolean skip = false;

        if (studentLLHashTable [H1] [0] == key)
        {
            System.out.println();
            System.out.println("Student found!");
            System.out.println("Key: " + key);
            System.out.println("Data1: " + studentLLHashTable [H1] [2]);
            System.out.println("Data2: " + studentLLHashTable [H1] [3]);
        }
        else
        {

            while (studentLLHashTable [(H1 + probe) % numKeys] [0] != key && probe <= numKeys)
            {
                probe++;

                if (probe > numKeys)
                    skip = true;

            }

            if (!skip)
            {
                System.out.println();
                System.out.println("Student found!");
                System.out.println("Key: " + key);
                System.out.println("Data1: " + studentLLHashTable[(H1 + probe) % numKeys][2]);
                System.out.println("Data2: " + studentLLHashTable[(H1 + probe) % numKeys][3]);
            }
            else
            {
                System.out.println();
                System.out.println("Student not found!");
            }

        }




    }

}
