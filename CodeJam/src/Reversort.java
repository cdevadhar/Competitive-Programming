import java.io.*;
import java.util.*;
public class Reversort {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = 1;
		for (int i=0; i<t; i++) {
			int n =7;
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for (int j=0; j<n; j++) {
				int m = in.nextInt();
				numbers.add(m);
				
			}
			System.out.println("Case #" + (i+1) + ": " + reversort(numbers));
//			for(int k=0; k<n; k++) {
//				System.out.println(numbers.get(k));
//			}
		}
	}
	
	public static int reversort(ArrayList<Integer> numbers) {
		int cost = 0;
		for (int i=0; i<numbers.size(); i++) {
			List<Integer> sublist = numbers.subList(i, numbers.size());
			int j = numbers.indexOf(Collections.min(sublist));
			List<Integer> sub = numbers.subList(i, j+1);
			Collections.reverse(sub);;
			for (int k=i; k<=j; k++) {
				numbers.set(k, sub.get(k-i));
			}
			cost +=(j-i+1);
			
		}
		return cost-1;
	}

}
