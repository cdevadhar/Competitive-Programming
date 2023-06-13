import java.io.*;
import java.util.*;
public class ProjectEuler {
	public static void main(String[] args) {
		problem3();
	}
	
	public static void problem1() {
		int sum = 0;
		for (int i=1; i<1000; i++) {
			if (i%3==0 || i%5==0) sum +=i;
		}
		System.out.println(sum);
	}
	public static void problem2() {
		int a=1;
		int b=1;
		int sumEvens =0;
		while (a<4000000) {
			int temp=a;
			a = b;
			b+=temp;
			System.out.println(a+" "+b);
			if (a%2==0) sumEvens+=a;
		}
		System.out.println(sumEvens);
	}
	public static void problem3() {
		double num = 600851475143.0;
		for (int i=3; i<Math.sqrt(600851475143.0); i+=2) {
//			System.out.println(i);
			while(num%i==0) {
				
				num = num/i;
				System.out.println(num);
				
			}
		}
		System.out.println(num);
	}
	
	
}
