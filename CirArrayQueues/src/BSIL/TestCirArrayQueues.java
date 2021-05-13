package BSIL;

import java.util.*;

public class TestCirArrayQueues {

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to the election survey queue! ");

        System.out.println();
        System.out.print("Please enter the size of the queue: ");

        int maxSize = scan.nextInt();

        CirArrayQueues myArray = new CirArrayQueues(maxSize);

        int option;

        do {

            System.out.println();
            System.out.println("----- MAIN MENU -----");
            System.out.println("0 – Exit Program ");
            System.out.println("1 – Enqueue ");
            System.out.println("2 – Dequeue ");
            System.out.println("3 – Size ");
            System.out.println("4 – Front ");
            System.out.println("5 – Print Queue ");

            System.out.println();
            System.out.print("Please enter your selection: ");

            option = scan.nextInt();

            switch (option)
            {

                case 0:
                    System.out.println();
                    System.out.println("***ENDING PROGRAM***");
                    break;

                case 1:
                    System.out.println();
                    myArray.printInfo();

                    System.out.println();
                    System.out.println("Please enter name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Please enter age: ");
                    int age = scan.nextInt();
                    System.out.println("Please enter your political affiliation: ");
                    scan.nextLine();
                    String polAff = scan.nextLine();
                    myArray.enqueue(name, age, polAff);

                    System.out.println();
                    myArray.printInfo();
                    break;

                case 2:
                    System.out.println();
                    myArray.printInfo();

                    myArray.dequeue();

                    System.out.println();
                    myArray.printInfo();
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Size: " + myArray.size());
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Front: " + myArray.front().toString());
                    System.out.println();
                    break;

                case 5:
                    myArray.printInfo();

            }



        }while (option != 0);

    }
}
