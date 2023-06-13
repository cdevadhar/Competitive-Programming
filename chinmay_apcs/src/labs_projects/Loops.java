package labs_projects;

/**
 * Unit4.java - Lab for Unit 4 to practice while/for loops
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 *
 */
public class Loops {
    // Calls all static methods written
    public static void main(String[] args) {
        multiplicationTable(3);
        multiplicationTable(6);
        findPrime(20);
        findPrime(37);
        palindromeWord("civic");
        palindromeWord("computer");
        checkerBoard(4);
        checkerBoard(7);
        diamond(3);
        diamond(5);
        xmasTree(5);
        xmasTree(7);
        birthdayCake(3, 4);
        birthdayCake(5, 3);
        verbalArithmetic();
    }

    private static void findPrime(int i) {
		// TODO Auto-generated method stub
		
	}

	// Task 1 - print multiplication table starting at 1 to n
    // There are n rows, each with 10 columns
    // Each element is the row multiplied by the column
    public static void multiplicationTable(int n) {
        System.out.println("\n[Task 1 - Multiplication Table]");
        System.out.println("multiplicationTable(" + n + ")");
        // Print out the first row showing labels for each column
        for (int i = 1; i <= 10; i++) {
            System.out.print("\t" + "X" + i);
        }
        System.out.println();
        // The outer for loop is for each row
        for (int i = 1; i <= n; i++) {
            // Print the label for the row
            System.out.print("X" + i + "\t");
            for (int j = 1; j <= 10; j++) {
                // In the inner for loop for each column in the row, carry out the multiplication
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

   // Find all prime numbers up to n
   public static void findPrimes(int n) {
        System.out.println("\n[Task 2 - Find Primes]");
        System.out.println("findPrimes()");
        // Create an array of size n+1
        boolean[] primes = new boolean[n+1];
        // Set all elements to true
        for (int i = 0; i < primes.length; i++) {
             primes[i] = true;
        }
        // Set the first two elements to false
        primes[0] = false;
        primes[1] = false;
        // Loop through the array
        for (int i = 2; i < primes.length; i++) {
             // If the element is true, it is a prime number
             if (primes[i]) {
                // Print the prime number
                System.out.print(i + " ");
                // Loop through the array
                for (int j = i*2; j < primes.length; j += i) {
                 // Set the element to false
                 primes[j] = false;
                }
             }
        }
   }

    // Task 3 - find whether word is a palindrome word
    public static void palindromeWord(String word) {
        System.out.println("\n[Task 3 - Palindrome Word]");
        System.out.println("palindromeWord(" + word + ")");
        String reversedWord = "";

        // First reverse the word by looping through it backwards and addinc characters to a new string
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        // Check if the reversed word is the same as the word - if it is, then the word is a palindrome
        if (reversedWord.equals(word)) {
            System.out.println(word + " is a palindrome word.");
        } else {
            System.out.println(word + " is not a palindrome word.");
        }

    }

    // Task 4 - print a n by n checker board with * and _
    public static void checkerBoard(int n) {
        System.out.println("\n[Task 4 - Checker Board]");
        System.out.println("checkerBoard(" + n + ")");

        // Outer for loop for each row
        for (int i = 0; i < n; i++) {
            // Inner for loop for each column
            for (int j = 0; j < n; j++) {
                // The pattern is that if row+column is a multiple of 2, the element should be a star
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                } 
                // Otherwise it should be a dash
                else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }

    }

    // Task 5 - print a diamond with * with the given side length n
    public static void diamond(int n) {
        System.out.println("\n[Task 5 - Diamond]");
        System.out.println("diamond(" + n + ")");
        // Figure out the initial number of spaces for the first line
        int numSpaces = (n - 1);
        // The first line will always have one star
        int numStars = 1;
        // Loop the calculated amount of times (this is how many layers are in the diamond)
        for (int i = 0; i < 2 * n - 1; i++) {
            // Print numSpaces number of spaces
            for (int j = 0; j < numSpaces; j++)
                System.out.print(" ");
            //Print numStars number of stars
            for (int j = 0; j < numStars; j++)
                System.out.print("*");
            System.out.println();
            // If we haven't reached the widest part of the diamond, keep increasing its size
            if (i < n - 1) {
                numStars += 2;
                numSpaces--;
            } 
            // Otherwise, decrease its size
            else {
                numStars -= 2;
                numSpaces++;
            }
        }

    }

    // Task 6 - print a letter Christmas tree
    public static void xmasTree(int n) {
        System.out.println("\n[Task 6 - Letter Christmas Tree]");
        System.out.println("xmasTree(" + n + ")");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // Maintain the current index of the new character
        int index = 1;
        // First print out the first layer with the right amount of spaces
        for (int j = 0; j < n - 1; j++)
            System.out.print(" ");
        System.out.println("a");
        // Store 2 strings - previous and reversed. Each line will have half the previous line (stored in previous) and the reverse of that (stored in reversed)
        // Plus a new character in between
        String previous = "a";
        String reversed = "a";
        // Loop to generate each layer
        for (int i = 0; i < n - 1; i++) {
            // Generate the calculated number of spaces
            for (int j = i; j < n - 2; j++)
                System.out.print(" ");
            // Print out the layer using the 3 string variables
            System.out.println(previous + alphabet.charAt(index) + reversed);
            // Previous adds on the new letter for the next line
            previous += alphabet.charAt(index);
            // Reversed does the same thing, but backwards
            reversed = alphabet.charAt(index) + reversed;
            index++;
        }

    }

    // Task 7 - birthday cake
    // First parameter is # of layers
    // Second parameter is like the radius (# of dashes on the top layer)
    public static void birthdayCake(int layer, int radius) {
        System.out.println("\n[Task 7 - Birthday Cake]");
        System.out.println("birthdayCake(" + layer + ", " + radius + ")");
        // Track the radius of the current cake layer
        int currRadius = radius;
        // Calculate the initial number of spaces
        int numSpaces = (layer - 1) * radius;
        // Loop to generate each layer
        for (int i = 0; i < layer; i++) {
            // Print the correct amount of spaces
            for (int j = 0; j < numSpaces; j++)
                System.out.print(" ");
            System.out.print("+");
            // Use currRadius to print the right amount of dashes between the pluses
            for (int j = 0; j < currRadius; j++)
                System.out.print("-");
            System.out.println("+");

            for (int j = 0; j < numSpaces; j++)
                System.out.print(" ");
            // Repeat the above process for the middle part of the layer
            System.out.print("|");
            for (int j = 0; j < currRadius; j++)
                System.out.print(" ");
            System.out.println("|");
            // Repeat the above process for the lowerr part of the layer
            for (int j = 0; j < numSpaces; j++)
                System.out.print(" ");
            System.out.print("+");
            for (int j = 0; j < currRadius; j++)
                System.out.print("-");
            System.out.println("+");
            // Update currRadius based on the pattern of how radius should increase
            currRadius += 2 * radius;
            // Update numSpaces also based on the pattern
            numSpaces -= radius;
        }
    }

    // Task 8 - verbal arithmetic
    // Find the number that satisfied the following multiplication.
    // A-E represent different digit.
    // ABCDE
    // X A
    // ------------
    // EEEEEE
    public static void verbalArithmetic() {
        System.out.println("\n[Task 8 - Verbal Arithmetic]");
        System.out.println("verbalArithmetic()");
        int loops = 0;
        // There are only 9 options for EEEEEE: 111111, 222222, and so on, so we can try all of them
        for (int i = 1; i < 10; i++) {
            // Generate EEEEEE easily using a string, then converting to an int
            int num = Integer.parseInt("" + i + i + i + i + i + i);
            // Use a for loop to check if the number EEEEEE is divisible by each one digit number (this is A)
            for (int j = 2; j < 10; j++) {
                loops++;
                // If it is, check the other conditions
                if (num % j == 0) {
                    int abcde = num / j;
                    // Make sure A in abcde is equal to the A it is multiplied by and that E in ABCDE is equal to E in EEEEEE
                    if (abcde % 10 == i && abcde / 10000 == j) {
                        // If all the conditions are met, print the equation
                        System.out.println("     " + abcde);
                        System.out.println("  X      " + j);
                        System.out.println("------------");
                        System.out.println("    " + num);
                        System.out.println("number of loops: " + loops);
                    }
                }
            }
        }
    }

}