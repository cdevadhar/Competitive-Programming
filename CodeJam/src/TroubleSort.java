import java.io.*;
import java.util.*;
public class TroubleSort {
	static Scanner in;
	static int t;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			System.out.println(n);
			ArrayList<Integer> even = new ArrayList<Integer>();
			ArrayList<Integer> odd = new ArrayList<Integer>();
			for (int j=0; j<n; j++) {
				int m = in.nextInt();
				if (j%2==0) even.add(m);
				else odd.add(m);
//				
			}
			Collections.sort(even);
			Collections.sort(odd);
			
			System.out.println();
			boolean isSorted = true;
			for (int k=0; k<odd.size(); k++) {
				if (odd.get(k)<even.get(k)) {
					System.out.println("Case #" + i + ": "+k);
					isSorted = false;
					
				}
				if (k+1<even.size()) {
					System.out.println("bruh");
					if (even.get(k+1)<odd.get(k)) {
						System.out.println("Case #" + i + ": " + k);
						isSorted = false;
					}
				}
			}
			if (isSorted==true) System.out.println("Case #" + i + ": OK");
			
		}
	}
}
