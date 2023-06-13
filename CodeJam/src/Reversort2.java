import java.io.*;
import java.util.*;
public class Reversort2 {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int c = in.nextInt();
			System.out.println("Case #" + (i+1) + ": " + engineer(n, c));
		}
	}
	
	public static String engineer(int n, int c) {
		int max = 0;
		int min = n-1;
		
		for (int i=2; i<=n; i++) {
			max+=i;
		}
		if (c>max || c<min) return "IMPOSSIBLE";
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			numbers.add(i+1);
		}
		boolean done = false;
		while (!done) {
			
			Collections.shuffle(numbers);
			
			ArrayList<Integer> nums = new ArrayList<Integer>(numbers);
//			System.out.println(reversort(numbers));
			
			if (reversort(numbers) == c) {
				String s = "";
				for (int i=0; i<n; i++) {
					if (i<n-1) {
						s = s.concat(String.valueOf(nums.get(i))+ " ");
					}
					else s = s.concat(String.valueOf(nums.get(i)));
					
				}
				done = true;
				
				return s;
				
			}
			
			
		}
		
		return null;
		
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
