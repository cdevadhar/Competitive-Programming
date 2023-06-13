import java.io.*;
import java.util.*;
public class Packmen {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();

		int n = in.nextInt();
		String s = in.next();
		int[] prefix = new int[n+1];
		ArrayList<Integer> packmen = new ArrayList<Integer>();
		LinkedList<Integer> asterisks = new LinkedList<Integer>();
		for (int i=0; i<n; i++) {
			prefix[i+1] = prefix[i];
			if (s.charAt(i)=='*') {
				asterisks.add(i);
				prefix[i+1]++;
			}
			if (s.charAt(i)=='P') packmen.add(i);
		}
		int hi = n;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			LinkedList<Integer> temp = (LinkedList<Integer>) asterisks.clone();
			if (doesWork(mid, packmen, temp, temp.size(), prefix)) {
				hi =mid;
			}
			else lo = mid+1;
		}
		System.out.println(hi);
//		System.out.println(doesWork(2, packmen, asterisks, asterisks.size(), prefix));
	}
	public static boolean doesWork(int seconds, ArrayList<Integer> packmen, LinkedList<Integer> asterisks, int a, int[] prefix) {
		int eaten = 0;
		int prev = 0;
		for (int i=0; i<packmen.size(); i++) {
			if (asterisks.isEmpty()) break;
			int leftMost = asterisks.peek();
//			System.out.println(leftMost);
			if (leftMost<packmen.get(i)) {
				int distance = Math.min(prefix.length-packmen.get(i)-2,(seconds -(packmen.get(i)-leftMost))/2);
//				System.out.println(distance);
				int numEaten = prefix[packmen.get(i)+distance+1]-prefix[leftMost];
				eaten+=numEaten;
				while (numEaten>0) {
					asterisks.poll();
					numEaten--;
				}
			}
			else {
				if (packmen.get(i)+seconds>=prefix.length-2) {
					return true;
				}
				int numEaten = prefix[packmen.get(i)+seconds+1]-prefix[leftMost];
				eaten+=numEaten;
				while (numEaten>0) {
					asterisks.poll();
					numEaten--;
				}
			}
		}
//		System.out.println(eaten);
		if (eaten>=a) return true;
		return false;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	            new InputStreamReader(System.in));
	    }
	    

	    public String next() throws IOException
	    {
	        while (st == null || !st.hasMoreElements()) {
	           
	            st = new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }

	    public int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

	    public long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

	    public double nextDouble() throws NumberFormatException, IOException
	    {
	        return Double.parseDouble(next());
	    }

	    public String nextLine() throws IOException
	    {
	        String str = br.readLine();
	        return str;
	    }
	}
}
