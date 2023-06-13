package labs_projects;
/**
 * Unit1.java
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 *
 *
 */

import java.util.Scanner;

public class Unit1
{
    private static Scanner kb = new Scanner(System.in);

    // [Problem 01 - Calculate an Area for a Circle]
    // A user enters the radius (int) for the circle and it prints the area of the circle (double).
    public static void circleArea()
    {
	// Pi is stored as a final double variable because it does not change.
    	final double PI = 3.14;
    // Prompting the user for input
    	System.out.println("Please enter the radius [int] of a circle: ");
    	int radius = kb.nextInt();
    // Use the formula a = pi* r^2
    	double area = radius*radius*PI;
    	System.out.print("The area of a circle with a radius of " + radius + " is: ");
    // Format to print with 2 decimal places
    	System.out.printf("%.02f", area);
    	System.out.println(".");
    	
    }

    // [Problem 02 - Hot Dog]
    // This calculates the total cost for # of hot dogs a user wants to buy, including tax.
    // Tax rate is 10.25%.
    public static void hotDog()
    {
	// Prompt the user to input the number of hot dogs
    	System.out.println("One hot dog is $2.50. Please enter the number of hot dogs you want to buy: ");
    	int hotDogs = kb.nextInt();
    	double preTaxCost = hotDogs*2.5;
    	double tax = preTaxCost*0.1025;
    // The total bill is pretax cost added to the tax
    	double cost = preTaxCost+tax;
    	System.out.print("Pretax cost: $");
    // Print all values formatted to have 2 decimal places.
    	System.out.printf("%.02f", preTaxCost);
    	System.out.println();
    	System.out.print("Tax: $");
    	System.out.printf("%.02f", tax);
    	System.out.println();
    	System.out.print("Final cost : $");
    	System.out.printf("%.02f", cost);
    	System.out.println();
    }

    // [Problem 03 - Hot Stuff]
    // A user will enter a temperature (int) in Fahrenhei
    // and it will be converted to the temperature Celsius (rounded to the nearest numbers)
    public static void hotStuff()
    {
	// Prompt the user to enter a temperature in Fahrenheit
    	System.out.println("Please enter a temperature (int) greater or equal to 32 in Fahrenheit: ");
    	int temperature = kb.nextInt();
    // Apply the celsius to fahrenheit formula
    	double celsius = (5.0/9.0)*(temperature-32);
    // Use the rounding formula learned in the unit
    	int roundedCelsius = (int)(celsius+0.5);
    	System.out.println(temperature + " degrees Fahrenheit is " + roundedCelsius + " degrees Celsius.");
    	
    }

    // [Problem 04 - Dream Team]
    // This puts players into a team of 6 and tells you how many teams it makes
    // and how many players are left without a team.
    public static void dreamTeam()
    {
 	// Prompt the user to enter the number of players
    	System.out.println("Please enter a number of players to divide into teams: ");
    	int players = kb.nextInt();
    // Int division truncates decimals, so this returns a whole number of teams
    	int numTeams = players/6;
    // Modulo returns the remaining players after teams are chosen
    	int leftover = players%6;
    	System.out.println("We can make " + numTeams + " teams of six with " + leftover + " players left over.");
    	
   }
    

    // [Problem 05 - Loose Change]
    // This takes in an integer in cents and give you the least coin combinations.
    public static void looseChange()
    {
	// Prompt the user to enter the amount of change
    	System.out.println("Please enter a number of cents to divide into change: ");
    	int cents = kb.nextInt();
    // First finf the number of quarters, then subtract their value from total number of cents
    	int quarters = cents/25;
    	cents-=(quarters*25);
    // Do the same for dimes and nickels
    	int dimes = cents/10;
    	cents-=(dimes*10);
    	int nickels = cents/5;
    	cents-=(nickels*5);
    // Any remaining coins have to be pennies
    	int pennies = cents;
    	System.out.println("Your change is: ");
    	System.out.println("Quarters: " + quarters);
    	System.out.println("Dimes: " + dimes);
    	System.out.println("Nickels: " + nickels);
    	System.out.println("Pennies: " + pennies);
    // The total is the number of each coin multiplied by its value
    	System.out.println("Total: " + (quarters*25 + dimes*10 + nickels*5 + pennies) + " cents");
    }

    public static void main(String[] args)
    {
        System.out.println("[Problem 01 - Calculate an Area for a Circle]");
        circleArea();
        System.out.println();
        System.out.println("[Problem 02 - Hot Dog]");
        hotDog();
        System.out.println();
        System.out.println("[Problem 03 - Hot Stuff]");
        hotStuff();
        System.out.println();
        System.out.println("[Problem 04 - Dream Team]");
        dreamTeam();
        System.out.println();
        System.out.println("[Problem 05 - Loose Change]");
        looseChange();
        kb.close();
   }
}
