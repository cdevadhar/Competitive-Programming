package labs_projects;
/**
 * Recursion.java  
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 * For Unit 10 recursion lab
 * Total 12 tasks.
 * The main method will call recursive methods to perform various tasks.
 */ 
public class Recursion {
    public static void main(String[] args)
    {
        // Test case #1: Sum all natural numbers from 1 up to n
        System.out.println("[1. Sum natural numbers up to n]");
        System.out.println("================================");
        System.out.println("Sum natural numbers 1 to 4: " + sumNumbers(4));
        System.out.println("Sum natural numbers 1 to 25: " + sumNumbers(25));
        System.out.println();

        // Test case #2: Add all digits of a given number n
        System.out.println("[2. Add all digits of a given number n]");
        System.out.println("=======================================");
        System.out.println("Sum of digits 1234: " + sumDigits(1234));
        System.out.println("Sum of digits 8379014: " + sumDigits(8379014));
        System.out.println();

        // Test case #3: Reverse a given string
        System.out.println("[3. Reverse a given string]");
        System.out.println("===========================");
        System.out.println("Reverse of \"noon\" is: " + reverseString("noon"));
        System.out.println("Reverse of \"Rolls Royce\" is: " + reverseString("Rolls Royce"));
        System.out.println();

        // Test case #4: Determine a palindrome word
        // Must call reverseString in #3
        System.out.println("[4. Palindrome words]");
        System.out.println("=====================");
        if ("noon".equals(reverseString("noon")))
            System.out.println("\"noon\" is a palindrome word");
        else
            System.out.println("\"noon\" is not a palindrome word"); 

        if ("California".equals(reverseString("California")))
            System.out.println("\"California\" is a palindrome word");
        else
            System.out.println("\"California\" is not a palindrome word"); 
        System.out.println();

        // Test case #5: Reverse all digits of a given number n
        System.out.println("[5. Reverse all digits of a given number n]");
        System.out.println("===========================================");
        
        // There are different ways to implement this.
        // You can treat the number as a number
        // Or you can handle it as a number/string
        // You can pick one of these two test cases that work for your method
        // Uncomment the one you decide to use
        // Test case 5a - mostly treat n as a string.
        // This will call a method which returns a string.
        System.out.println("Reverse of 1234: " + reverseDigits(1234));
        System.out.println("Reverse of 83791306: " + reverseDigits(83791306));
        System.out.println();

        // Test case #6: Decimal to binary conversion
        System.out.println("[6. Convert a decimal to a binary]");
        System.out.println("============================");
        System.out.print("10 in binary: ");
        binary(10);
        System.out.println();
        System.out.print("32 in binary: ");
        binary(32);
        System.out.println();
        System.out.println();        

        // Test case #7: Binary to decimal conversion
        System.out.println("[7. Convert a binary to a decimal]");
        System.out.println("============================");
        System.out.print("Binary 1101 to decimal: " + decimal (1101));
        System.out.println();
        System.out.print("Binary 11101 to decimal: " + decimal (11101));
        System.out.println();
        System.out.println();        

        // Test case #8: Find exponential values
        System.out.println("[8. Find the exponential value for base b and exponent m]");
        System.out.println("============================");
        System.out.println("Exponent (2 to 4th power): " + exponent(2, 4));
        System.out.println("Exponent (3 to 6nd power): " + exponent(3, 6));
        System.out.println();

        // Test case #9: Logarithm
        System.out.println("[9. Find the logarithmic value for base b and exponential value m]");
        System.out.println("============================");
        System.out.println("Log base 2 of 16: " + logarithm(16, 2));
        System.out.println("Log base 3 of 6561: " + logarithm(6561, 3));
        System.out.println();

        // Test case #10: GCF using Euclid's Algorithm
        System.out.println("[10. Find the GCF of a and b]");
        System.out.println("============================");
        System.out.println("GCF of 20 and 8: " + gcf(20, 8));
        System.out.println("GCF of 15 and 30: " + gcf(15, 30));
        System.out.println();

        // Test case #11: Fibonacci Sequence
        int sum = 0;
        System.out.println("[11. Fibonacci Sequence]");
        System.out.println("=======================");
        System.out.print("4 terms of Fibonacci sequence: ");
        for (int i = 0; i < 4; i++)
        {
            sum += fibonacci(i);
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        System.out.println("Sum of 4 terms of Fibonacci sequence: " + sum);
        System.out.println();

        sum = 0;
        System.out.print("8 terms of Fibonacci sequence: ");
        for (int i = 0; i < 8; i++)
        {
            sum += fibonacci(i);
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        System.out.println("Sum of 8 terms of Fibonacci sequence: " + sum);
        System.out.println();

        // Test case #12: Merge Sort and binary search
        System.out.println("[12. Merge sort and binary search]");
        System.out.println("=================================");
        int[] intArray = {4, 2, 8, 6, 0, 5, 1, 7, 3, 9};
        int[] tempArray = new int[intArray.length];

        System.out.print("Array before sorting: ");
        for (int i = 0; i < intArray.length; i++)
        {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        
        // Test case to show binary search won't work on unsorted data.
        // 8 is the target, 0 and intArray.length are the begin and end
        // indexes of intArray we will look through for the target.
        int pos = recursiveBinarySearch(intArray, 8, 0, intArray.length);
        System.out.println("8 is in array index: " + pos);
        System.out.println("Is this correct? Most likely the answer is wrong...");
        System.out.println();

        // Sort the array with merge sort
        // intArray contains unsorted elements. 0 and intArray.length-1 are the
        // start and end indexes where we will sort elements.
        // Sorted elemented are put in tempArray first, but then it will be
        // copied over to intArray so intArray will be sorted after mergeSort returns.
        mergeSort(intArray, 0, intArray.length - 1, tempArray);
        
        System.out.print("Array after sorting : ");
        for (int i = 0; i < intArray.length; i++)
        {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        
        // Test binary search again on sorted data.  Should work now.
        pos = recursiveBinarySearch(intArray, 8, 0, intArray.length);
        System.out.println("8 is in array index: " + pos);
        System.out.println("It should be correct now!");
        System.out.println();

        // Test case #13: Print the Pascal Triangle for n rows
        // You probably need two passes.  First is a for loop to
        // print the leading spaces and then use a recursive
        // method to print all numbers.
        System.out.println("[13. Pascal Triangle]");
        System.out.println("=====================");
        System.out.println("4 rows of Pascal Triangle:");
        printPascalTriangle(4);
        System.out.println();

        System.out.println("7 rows of Pascal Triangle:");
        printPascalTriangle(7);
        System.out.println();
    }

    // ===============All methods start here================
   
    public static int sumNumbers(int n)
    {
        // Recursive method to sum numbers from 1 to n
        // Base case: n = 1
        if (n == 1)
        {
            return 1;
        }
        else
        {
            // Recursive case: n > 1
            // sumNumbers(n-1) is the sum of the numbers from 1 to n-1, so we add that sum to n
            return n + sumNumbers(n-1);
        }
        
    }

    // #2 Add all digits of a given number n
    public static int sumDigits(int n)
    {
        // Recursive method to sum digits of a number
        // Base case: only one digit
        if (n < 10)
        {
            return n;
        }
        // Recursive case: more than one digit
        else
        {
            return n % 10 + sumDigits(n / 10);
        }
    }

    // #3/#4 Reverse a given string
    public static String reverseString(String str)
    {
        // Recursive method to reverse a string
        if (str.length() == 1)
        {
            return str;
        }
        // Add the last character to the beginning, followed by recursing the method on the rest of the string
        else
        {
            return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
        }
    }

    // #5 Reverse all digits of a given number n
    // We return a string consisting of the digits in reverse order
    public static String reverseDigits(int n)
    {
        // Recursive method to reverse digits of a number
        if (n < 10)
        {
            return Integer.toString(n);
        }
        else
        {
            return Integer.toString(n % 10) + reverseDigits(n / 10);
        }
    }
    
    // #6 Convert a decimal numberto a binary number
    public static void binary(int num)
    {
        // Recursive method to convert a decimal number to a binary number
        // If the number is 1 or 0, its already in binary
        if (num < 2)
        {
            System.out.print(num);
        }
        // Recursion: printing the remainders in reverse order
        else
        {
            binary(num / 2);
            System.out.print(num % 2);
        }
    }

    // #7 Convert a binary number to a decimal number
    public static int decimal(int num)
    {
        // Recursive method to convert a binary number to decimal
        if (num==0) return 0;
        else return (num%10) + 2*decimal(num/10);


    }
    
    // #8 Find exponents
    // The base and the exponent are integers.
    public static int exponent(int base, int exp)
    {
        // Find the exponent of a base
        // Base case: anything to the 0th power is 1
        if (exp == 0)
        {
            return 1;
        }
        // Multiply the base by itself raised to the exponent-1
        else
        {
            return base * exponent(base, exp - 1);
        }
    }

    // #9 Find Logarithms - due to rounding, limit parameter to only positive int
    public static int logarithm(int log, int base)
    {
        // Recursive method to find the logarithm of a number
        if (log < base)
        {
            return 0;
        }
        else
        {
            return 1 + logarithm(log / base, base);
        }
    }

    // #10 Find GCF of a and b using Euclid's Algorithm
    public static int gcf(int a, int b)
    {
        // Euclid's Algorithm to find the GCF of a and b
        if (b == 0)
        {
            return a;
        }
        // Recursive case: uses the modulo operator
        else
        {
            return gcf(b, a % b);
        }
    }

    // #11 Find n terms of Fibonacci sequence
    public static int fibonacci(int n)
    {
        // Recursive method to find the nth term of the Fibonacci sequence
        // 2 base cases for 0 and 1
        if (n == 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        // Sum of the 2 previous terms
        else
        {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // #12 Merge Sort
    public static void mergeSort(int[] arr, int from, int to, int[] temp)
    {
        // Recursive method to sort an array using merge sort
        if (from < to)
        {
            int mid = (from + to) / 2;
            mergeSort(arr, from, mid, temp);
            mergeSort(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }

    // Merge two arrays - array index range is [from] to [to]
    // temp is an array to hold the sorted elements.
    // Need to copy temp to arr once the sorting is completed.
    public static void merge(int[] arr, int from, int mid, int to, int[] temp)
    {
        // Merge two sorted arrays
        int i = from;
        int j = mid + 1;
        int k = 0;
        // Choose the element that is smaller among the 2 arrays
        // Place that in the new array
        while (i <= mid && j <= to)
        {
            if (arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // Place any leftover elements into the new array
        while (i <= mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= to)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0; k < to - from + 1; k++)
        {
            arr[from + k] = temp[k];
        }

    }

    // #12 Binary search - return the index of the target
    // start and end are the array indexes that we will look through for the target.
    public static int recursiveBinarySearch(int[] arr, int target, int start, int end)
    {
        // Recursive method to find the index of the target in an array
        if (start > end)
        {
            return -1;
        }
        else
        {
            int mid = (start + end) / 2;
            if (arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] > target)
            {
                return recursiveBinarySearch(arr, target, start, mid - 1);
            }
            else
            {
                return recursiveBinarySearch(arr, target, mid + 1, end);
            }
        }
    }
    
    // #13 Print the Pascal Triangle for n rows
    /**
     * n = 1, print (a+b)^0 
     *                                      1
     * n = 2, print (a+b)^1
     *                                      1
     *                                     1 1
     * n = 3, print (a+b)^2
     *                                      1
     *                                     1 1
     *                                    1 2 1
     */

    public static void printPascalTriangle(int n)
    {
        // Use a helper recursive method
        pascalTriangleHelper(n, 1);
        // Recursive method to print the Pascal Triangle for n rows
    }
    public static void pascalTriangleHelper(int n, int row)
    {
        // Recursive method to print the Pascal Triangle for n rows
        // FIrst print the right number of spaces
       int numSpaces = n-row;
       for (int i=0; i<numSpaces; i++)
       {
           System.out.print(" ");
       }
       int curr = 1;
       for (int i=0; i<row; i++) {
            System.out.print(curr + " ");
            // Formula for the next element in the triangle
            curr = curr * (row-i-1) / (i+1);
       }
       System.out.println();
       if (row<n) pascalTriangleHelper(n, row+1);
    }

}
