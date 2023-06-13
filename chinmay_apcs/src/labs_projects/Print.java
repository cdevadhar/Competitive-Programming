package labs_projects;
/**
 * Print.java for 1.2
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 *
 *
 */

public class Print
{
    /*
     * Example 1
     * No mistakes here!
     */
    public static void example1() {
        // Example 1: no mistakes here.
        System.out.println("This is my first Java program!");
        System.out.print("I hope ");
        System.out.println("I will type everything correctly!");
        System.out.print("I also hope I will");
        System.out.println(" get an A in this class!");
    }

    /*
     * Practicing println(), print(), string concatenation
     * Used System.out.println() to print my name
     * Used empty println() statements to print empty lines between my first and last name
     */
    public static void example2() {
        // We will practice print and println in this lab
        System.out.println("I " + "am " + "not " + "spacing things correctly.");
        System.out.println("I will correct this sentence above.");
        System.out.println("I will correct the sentences below.");
        System.out.print("First Name: Chinmay");
        System.out.println();
        System.out.print("Last Name: Devadhar");
        System.out.println();
    }

    /*
     * Example 3
     * Used 2 print() and 2 println() statements to make an answer key to the equation
     * Divided some lines into 2 parts to use one print() and one println()
     */
    public static void example3() {
        // CD - Printing an answer key to the equation
        // START
    	System.out.println("3(x + 10) - 5 = 10"); 
    	System.out.print("3(x + 10)");
    	System.out.println("     = 15");
    	System.out.print(" (x + 10)");
    	System.out.println("     =  5");
    	System.out.println("  x           = -5");
    	// END
    	
    }

    public static void main(String[] args)
    {
        System.out.println("Example 1:");
        example1();
        System.out.println();

        System.out.println("Example 2:");
        example2();
        System.out.println();

        System.out.println("Example 3:");
        
        example3();
    }
}
