import java.io.*;
import java.util.*;
public class TwoPointers {
	static int n, x;
	static int[] numbers;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		x = in.nextInt();
		numbers = new int[n];
		for (int i=0; i<n; i++) {
			numbers[i] = in.nextInt();
		}
//		sum2(x, numbers);
		for (int i=0; i<n; i++) {
			sum3(i);
		}
		
	}
	
	public static void sum2(int sum, int[] numbers) {
		
		int left = 0;
		int right = numbers.length-1;
		while (right>left) {
			if (numbers[left] + numbers[right]>sum) {
				right--;
			}
			if (numbers[left] + numbers[right]<sum) {
				left++;
			}
			else {
				System.out.println((left+1) + " " + (right+1));
				break;
			}
		}
	}
	public static void sum3(int middle) {
		int sum = x-middle;
		int[] array = Arrays.copyOfRange(numbers, middle+1, n);
		sum2(sum, array);
	}
	
}
