package labs_projects;

/**
 * Arithmetic.java for 1.4
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 *
 *
 */ 
import java.util.Scanner;

public class Arithmetic
{
    /**
     * When declaring a variable, we must first distinguish its type.
     * There are many types, but this lab will only focus on:
     * integer, double, and String
     */

    // Example 1: something simple
    public static void example1()
    {
        // Pay attention to result of x / y
    	// Int division rounds down, so 5/8 will return 0
        int x = 5;
        int y = 8;

        System.out.println("x = " + x + ", y = " + y); // String + int => int is treated as a String
        System.out.print("x + y = ");
        System.out.println(x + y);
        System.out.print("x * y = ");
        System.out.println(x * y);
        System.out.print("x / y = ");
        System.out.println(x / y);
        System.out.println();
    }

    // Example 2: dnum doesn't have to be decimal. Double automatically casts it to a double value, so when you print the value, it outputs a decimal, though.
    public static void example2()
    {
        // Pay attention to the result of dnum * x.  What type is it?
    	// dnum * x is a double. Double times int is a double.
        int x = 5;
        int y = 8;
        double dnum = 10;

        System.out.println("dnum = " + dnum);
        System.out.print("dnum * dnum = ");
        System.out.println(dnum * dnum);
        System.out.print("dnum * x = ");
        System.out.println(dnum * x);
        System.out.println();
    }

    // Example 3: Order of operations matters 
    public static void example3()
    {
        int x = 5;
        int y = 8;
        double dnum = 10;

        System.out.print("x / y * dnum = ");
        System.out.println(x / y * dnum);
        System.out.print("dnum * x / y = ");
        System.out.println(dnum * x / y);
        System.out.println();
    }

    // Example 4: increment (++)/decrement (--) operators
    // There are multiple different ways to increase the value of a variable x by 1: x++, x+=1, x=x+1, x-=-1
    // The same is true for subtracting 1 from a variable's value

    public static void example4()
    {
        int x = 5;
        int y = 8;

        System.out.println("x = " + x + ", y = " + y);
        System.out.print("Before x++, x is: ");
        System.out.print(x);
        // x+=1 is equivalent to x++, both increase the value of x by 1
        x+=1;
        System.out.print(".  After x++, x is: ");
        System.out.println(x);
        System.out.print("Before y--, y is: ");
        System.out.print(y);
        // y-=1 is equivalent to y--, both decrease the value of y by 1
        y-=1;
        System.out.print(".  After y--, y is: ");
        System.out.println(y);
        System.out.println();
    }

    // Example 5: This method uses a Scanner to read a name from the keyboard, then uses String concatenation to say hello to the user
    public static void example5()
    {
       
        // This is how we initialize scanners that read input from the user.
        Scanner kb = new Scanner(System.in);
        System.out.print("Please Enter your name: ");
        

        // START
        String name = kb.nextLine();
        // This line reads the next String input from the scanner, which will be the user's name
        System.out.println("Hello " + name + "!");
        // Use string concatenation to output a hello to whatever the user inputted as their name
        // END
        System.out.println();
 
    }

    // Example 6: This method reads in 5 integers using a Scanner. It calculates the sum and divides this by 5 to return an average.

    
    public static void example6()
    {
        // This function prints out the average of 5 numbers, so this line tells the user what to expect
        System.out.println("Average"); 

        int num_of_terms = 5;
        // The total sum of the numbers
        int total = 0;
        Scanner kb = new Scanner(System.in);


        // The two statements below are written differently, but accomplish the same task. (total+=x and total  = total + x)
        // total is replaced with the addition of a new number to total.
        System.out.print("Enter a number: ");
        total = total + kb.nextInt();
        System.out.print("Enter a number: ");
        total += kb.nextInt();
        System.out.print("Enter a number: ");
        total += kb.nextInt();
        System.out.print("Enter a number: ");
        total += kb.nextInt();
        System.out.print("Enter the last number: ");
        total += kb.nextInt();
        // Cast the total to a double to prevent it from being an integer division and rounding down
        // Changed variable name from mystery to average because this is no longer a mystery
        double average = (double) total / num_of_terms;
        
        System.out.println("The average of the 5 numbers is " + average);
        System.out.println();
       
    }


    // EXAMPLE 7
    // This method reads in the coefficients of a quadratic equation and calculates the roots of the equation.
    public static void example7()
    {
        Scanner kb = new Scanner(System.in);
        // The scanner takes in 3 inputs for the coefficients a, b, and c in a quadratic equation. It uses these in the quadratic formula to find the roots of the equation.
        System.out.print("Enter a = ");
        int a = kb.nextInt();

        System.out.print("Enter b = ");
        int b = kb.nextInt();

        System.out.print("Enter c = ");
        int c = kb.nextInt();
        // The discriminant is the part of the quadratic equation with b^2 - 4ac
        double discriminant = Math.sqrt(b*b-4*a*c);
        // To find the roots, use the quadratic formula x = (-b +/- sqrt(b^2 - 4ac))/2*a;
        // Since the discriminant is always a double, the division returns a double
        // Make sure to use parentheses to follow the order of operations in the quadratic formula.
        double rootA = (-1*b+discriminant)/(2*a);
        double rootB = (-1*b-discriminant)/(2*a);
        // Use the Math.max() method to print the larger root first.
        System.out.println("The two roots are: " + Math.max(rootA, rootB) + ", " + Math.min(rootA, rootB));
        // END

        kb.close();
    }

    public static void main(String[] args)
    {
//        System.out.println("Example 1:");
//        System.out.println("============");
//        example1();
//
//        System.out.println("Example 2:");
//        System.out.println("============");
//        example2();
//
//        System.out.println("Example 3:");
//        System.out.println("============");
//        example3();
//
//        System.out.println("Example 4:");
//        System.out.println("============");
//        example4();
//
//        System.out.println("Example 5:");
//        System.out.println("============");
//        example5();
//
//        System.out.println("Example 6:");
//        System.out.println("============");
//        example6();
//
//        System.out.println("Example 7:");
//        System.out.println("============");
//        example7();
    	  System.out.println((2*((double)7%4)));
    }
}
