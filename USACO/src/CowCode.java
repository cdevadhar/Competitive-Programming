import java.io.*;
import java.util.*;

public class CowCode {
	static char ans = ' ';
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("cowcode.in", "cowcode.out");
		String str = in.next();
		long n = in.nextLong();
		parse(str, n);
		in.pr.println(ans);
		in.pr.close();
	}
	public static void parse(String str, long index) {
//		System.out.println(index);
		if (index<=str.length()) {
			ans = str.charAt((int) (index-1));
			return;
		}
		long length = str.length();
		while (length<=index) {
			length*=2;
		}
		long insideIndex = index-length/2;
//		System.out.println(insideIndex);
		if (insideIndex==1) {
			parse(str, length/2);
		}
		else {
			parse(str, insideIndex-1);
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
