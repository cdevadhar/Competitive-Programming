import java.io.*;
import java.util.*;
public class CowOperations {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		String s = in.next();
		int[][] occPrefix = new int[s.length()+1][3];
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<3; j++) {
				occPrefix[i+1][j] = occPrefix[i][j];
			}
			if (s.charAt(i)=='C') occPrefix[i+1][0]++;
			else if (s.charAt(i)=='O') occPrefix[i+1][1]++;
			else occPrefix[i+1][2]++;
		}
		int q = in.nextInt();
		for (int i=0; i<q; i++) {
			int l = in.nextInt()-1;
			int r = in.nextInt()-1;
			int cOcc = occPrefix[r+1][0]-occPrefix[l][0];
			int oOcc = occPrefix[r+1][1]-occPrefix[l][1];
			int wOcc = occPrefix[r+1][2]-occPrefix[l][2];
			if ((oOcc%2==wOcc%2) && cOcc%2!=oOcc%2) in.pr.print('Y');
			else in.pr.print('N');
		}
		in.pr.close();
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
