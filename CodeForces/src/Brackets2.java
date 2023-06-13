import java.io.*;
import java.util.*;


public class Brackets2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			char[] s = in.next().toCharArray();
			int currIndex = 0;
			int deletions = 0;
			int index = 0;
			while (index<n) {
				if (s[index]=='(') {
					if (index<n-1) {
						index+=2;
						deletions++;
					}
					else break;
				}
				else {
					int temp = index;
					index++;
					while (index<n && s[index]!=')') {
						index++;
					}
					if (index<n && s[index]==')') {
						index++;
						deletions++;
					}
					else {
						index = temp;
						break;
					}
				}
			}
			System.out.println(deletions+" "+(n-index));
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
