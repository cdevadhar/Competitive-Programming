import java.io.*;
import java.util.*;
public class Literature {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			String[] arr = new String[3];
			for (int i=0; i<3; i++) {
				arr[i] = in.next();
			}
			boolean done = false;
			for (int i=0; i<3; i++) {
				if (done) break;
				for (int j=0; j<3; j++) {
					if (i==j) continue;
					String s = check(arr[i], arr[j], n);
					if (s==null) {
						continue;
					}
					in.pr.println(s);
					done=true;
					break;
				}
			}
		}
		in.pr.close();
	}
	public static String check(String s1, String s2, int n) {
		int[] zeros = new int[2];
		int[] ones = new int[2];
		for (int i=0; i<2*n; i++) {
			if (s1.charAt(i)=='0') zeros[0]++;
			else ones[0]++;
			if (s2.charAt(i)=='0') zeros[1]++;
			else ones[1]++;
		}
		if (zeros[0]>=n && zeros[1]>=n) {
			
			int index1=0;
			int index2=0;
			StringBuilder s = new StringBuilder();
			while (index1<2*n || index2<2*n) {
				if (index1<2*n && s1.charAt(index1)=='1') {
					s.append('1');
					index1++;
					continue;
				}
				if (index2<2*n && s2.charAt(index2)=='1') {
					s.append('1');
					index2++;
					continue;
				}
				s.append('0');
				index1++;
				index2++;
			}
			return s.toString();
		}
		else if (ones[0]>=n && ones[1]>=n) {
			
			int index1=0;
			int index2=0;
			StringBuilder s = new StringBuilder();
			while (index1<2*n || index2<2*n) {
				if (index1<2*n && s1.charAt(index1)=='0') {
					s.append('0');
					index1++;
					continue;
				}
				if (index2<2*n && s2.charAt(index2)=='0') {
					s.append('0');
					index2++;
					continue;
				}
				s.append('1');
				index1++;
				index2++;
			}
			return s.toString();
		}
		else return null;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
