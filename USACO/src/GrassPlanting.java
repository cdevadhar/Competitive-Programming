import java.io.*;
import java.util.*;
public class GrassPlanting {
	
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "planting.out");
		int n = in.nextInt();
		int[] connections = new int[n];
		int max = 0;
		for (int i=0; i<n-1; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			connections[a]++;
			connections[b]++;
			if (connections[a]>max) max=connections[a];
			if (connections[b]>max) max=connections[a];
		}
		System.out.println(max+1);
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
