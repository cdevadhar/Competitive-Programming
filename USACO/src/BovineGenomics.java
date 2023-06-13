import java.io.*;
import java.util.*;

public class BovineGenomics {
	static int n, m;
	static char[][] spotty;
	static char[][] nonSpotty;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("cownomics.in", "cownomics.out");
		n = in.nextInt();
		m = in.nextInt();
		spotty = new char[n][m];
		nonSpotty = new char[n][m];
		for (int i=0; i<n; i++) {
			String s = in.next();
			spotty[i] = s.toCharArray();
		}
		for (int i=0; i<n; i++) {
			String s = in.next();
			nonSpotty[i] = s.toCharArray();
		}
		int total=0;
		for (int i=0; i<m; i++) {
			for (int j=i+1; j<m; j++ ) {
				for (int k=j+1; k<m; k++) {
					total+=check(i, j, k);
				}
			}
		}
		in.pr.println(total);
		in.pr.close();
	}
	public static int check(int i, int j, int k) {
		HashSet<Triplet> spottyCode = new HashSet<Triplet>();
		for (int index=0; index<n; index++) {
			spottyCode.add(new Triplet(spotty[index][i], spotty[index][j], spotty[index][k]));
		}
		for (int index=0; index<n; index++) {
			if (spottyCode.contains(new Triplet(nonSpotty[index][i], nonSpotty[index][j], nonSpotty[index][k]))) return 0;
		}
		return 1;
	}
	static class Triplet {
		char A, B, C;
		public Triplet(char A, char B, char C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
		
		@Override
		public int hashCode() {
			return (A+B+C)-0;
		}
		
		@Override
		public boolean equals(Object other) {
			Triplet o = (Triplet) other;
			return A==o.A && B==o.B && C==o.C;
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
