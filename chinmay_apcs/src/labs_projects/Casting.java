package labs_projects;
/**
 * Casting.java
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 *
 *
 */

import java.util.Scanner;

public class Casting
{

    // Example 1: Concatenating numbers to strings, adding numbers
	
    public static void example1()
    {
        int a = 3;
        int b = 4;
        System.out.println("a = 3, b = 4");
        System.out.println();
        // Printing a+b in 4 different ways yields different results
        // String concatenation before adding treats the numbers as strings
        // Expressions in parentheses are evaluated first
        System.out.println("a + b is " +  (a+b));
        System.out.println("\"\" + a + b is " + a + b);
        System.out.println("4 + 5 + a + \"\" + b + a is " + (4+5+a+""+b+a));
        System.out.println("Result: + a + b is " + ("Result: " + a + b));
        System.out.println("Result: + (a + b) is " + ("Result: " + (a+b)));
        // END
    }

    // Example 2: There are times where we want to change between the type of number we are dealing with.
    // This concept is known as type-casting.
    // In this example, we change ints to doubles and vice versa
    public static void example2()
    {
        int num1 = 3;
        int num2 = 4;
        double d_num1 = 3.0; // The equivalent of num1 except it is of type double instead of int
        double d_num2 = 4.0; // The equivalent of num2 except it is of type double instead of int

        // Test int cast to double
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println();

        // Practicing the difference between double and int division
        // Casting parts of the expressions from int to double to change type of division
        System.out.print("num1 / num2 is 3/4 = ");
        System.out.println(num1/num2);
        System.out.print("(double)num1 / num2 is 3/4 = ");
        System.out.println((double)num1/num2);
        System.out.print("(double)(num1) / num2 is 3/4 = ");
        System.out.println((double)(num1)/num2);
        System.out.print("(double)(num1 / num2) is 3/4 = ");
        System.out.println((double)(num1/num2));
        
        // END
        System.out.println();
        System.out.println();

        // Test cast double to int
        System.out.println("d_num1 = " + d_num1 + ", d_num2 = " + d_num2);
        System.out.println();

        // This time, we practice casting from double to int
        // Casting only one of the divisor or dividend to an int doesn't change anything because int/double is still double
        System.out.print("d_num1 / d_num2 is 3.0/4.0 = ");
        System.out.println(d_num1/d_num2);
        System.out.print("(int)d_num1 / d_num2 is 3.0/4.0 = ");
        System.out.println((int)d_num1/d_num2);
        System.out.print("(int)(d_num1) / d_num2 is 3.0/4.0 = ");
        System.out.println((int)(d_num1)/d_num2);
        System.out.print("(int)(d_num1 / d_num2) is 3.0/4.0 = ");
        System.out.println((int)(d_num1/d_num2));
        // END
    }

    public static void main(String[] args)
    {
        System.out.println("Example 1:");
        System.out.println("============");
        example1();
        System.out.println();

        System.out.println("Example 2:");
        System.out.println("============");
        example2();
       
    }
}
