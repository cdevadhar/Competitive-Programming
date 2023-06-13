import java.io.*;
import java.util.*;

public class GetEven {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			char[] s = in.next().toCharArray();
			
			int[] closestPartner = new int[s.length];
			int[] suffixMin = new int[s.length];
			closestPartner[s.length-1] = Integer.MAX_VALUE;
			suffixMin[s.length-1] = Integer.MAX_VALUE;
			for (int c=0; c<26; c++) {
				char ch = (char)('a'+c);
				int earliestOcc = Integer.MAX_VALUE;
				for (int i=s.length-1; i>=0; i--) {
					if (s[i]==ch) {
						closestPartner[i] = earliestOcc;
						earliestOcc = i;
					}
				}
			}
			for (int i=s.length-2; i>=0; i--) {
				suffixMin[i] = Math.min(closestPartner[i], suffixMin[i+1]);
			}
			int pairs = 0;
			int index = 0;
			while (index<s.length) {
				if (suffixMin[index]==Integer.MAX_VALUE) break;
				index = suffixMin[index]+1;
				pairs++;
			}
			System.out.println(s.length-pairs*2);
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
