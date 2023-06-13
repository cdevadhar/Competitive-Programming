import java.io.*;
import java.util.*;
public class BovineShuffle {
	static int n;
	static int[] connections;
	static int[] condition;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "shuffle.out");
		n = in.nextInt();
		connections = new int[n];
		condition = new int[n];
		for (int i=0; i<n; i++) {
			connections[i] = in.nextInt()-1;
		}
		for (int i=0; i<n; i++) {
			if (condition[i]==0) {
				traverse(i);
			}
		}
		int num = 0;
		for (int i=0; i<n; i++) {
			if (condition[i]==2) {
				num++;
			}
		}
		System.out.println(num);
	}
	
	public static void traverse(int i) {
		HashSet<Integer> there = new HashSet<Integer>();
		while (condition[i] == 0) {
			there.add(i);
			condition[i] = 1;
			i = connections[i];
		}

		//cycle is found, mark all nodes that are part of cycle
		if (there.contains(i)) {
			int savei = i;
			do {
				condition[i] = 2;
				i = connections[i];
			} while (i != savei);
		}

	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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
