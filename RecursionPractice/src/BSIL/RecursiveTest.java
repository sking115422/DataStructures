package BSIL;

import java.util.Scanner;

public class RecursiveTest
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a string you would like reversed: ");

        String value = scan.nextLine();

        System.out.println(recFib(value));



    }

    public static String recFib (String value)
    {
        if (value == null || value.length() == 1)
            return value;
        else
            return recFib(value.substring(1)) + value.charAt(0);


    }

}
