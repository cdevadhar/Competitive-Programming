import java.io.*;
import java.util.*;
public class Rotations {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		char[] s = in.next().toCharArray();
		char[] t = in.next().toCharArray();
		int[] zeros = new int[2];
		int[] ones = new int[2];
		boolean equal = true;
		for (int i=0; i<n; i++) {
			if (s[i]!=t[i]) equal = false;
			if (s[i]=='0') zeros[0]++;
			else ones[0]++;
			if (t[i]=='0') zeros[1]++;
			else ones[1]++;
		}
		if (equal) System.out.println(0);
		else if (zeros[0]!=zeros[1]) System.out.println(-1);
		else {
			int first = -1;
			int prev = -1;
			int skipped = 0;
			int skipped0 = 0;
			int skipped1 = 1;
			for (int i=0; i<n; i++) {
				if (s[i]!=t[i]) {
					if (prev==-1) {
						prev = s[i];
						first = s[i];
					}
					else {
						if (s[i]!=prev) {
							prev = s[i];
						}
						else {
//							System.out.println(s[i]+" "+skipped0 +" "+skipped1);
							if (s[i]=='1') {
								if (skipped0>0) {
//									System.out.println("a");
									skipped0--;
									skipped1++;
								}
								else {
//									System.out.println("b");
									skipped++;
									skipped1++;
								}
								
							}
							else {
								if (skipped1>0) {
									skipped1--;
									skipped0++;
								}
								else {
									skipped++;
									skipped0++;
								}
							}
						}
					}
				}
			}
			
			System.out.println(skipped+1);
		}
		
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
