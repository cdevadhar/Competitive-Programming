import java.io.*;
import java.util.*;
public class Soulmates {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			long a = in.nextLong();
			long b = in.nextLong();
			long count=0;
			while (a!=b) {
//				System.out.println(a+" "+b);
				if (a>b) {
					if (a%2==0) {
						a/=2;
					}
					else a++;
					count++;
				}
				else {
					if (b-a<=4) {
						count+=(b-a);
						a=b;
						
					}
					else {
						if (2*a<=b) {
							if (b%2==0) {
								b/=2;
								count++;
							}
							else {
								b--;
								count++;
							}
						}
						else {
							if (a%2==1) {
								a++;
								count++;
							}
							else {
								a/=2;
								count++;
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
