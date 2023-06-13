import java.io.*;
import java.util.*;

public class BoringNumbers {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		long[] powers = new long[19];
		long[] prefix = new long[19];
		powers[0] = 1;
		prefix[0] = 0;
		for (int i=1; i<19; i++) {
			powers[i] = powers[i-1]*5;
			prefix[i] = powers[i]+prefix[i-1];
		}
		for (int i=0; i<t; i++) {
			long l = in.nextLong();
			long r = in.nextLong();
			
		}
	}
	
	public static int getBoringNumbers(long target, long[] powers, long[] prefix) {
		int num=1;
		int index = 0;
		for (int i=0; i<powers.length; i++) {
			if (target<num*10) break;
			num*=10;
			index++;
		}
		long boringNumbers = prefix[index];
		int jump = (int)Math.log10(boringNumbers%num);
		while (target>0) {
			
		}
		
		return 0;
		
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
