import java.io.*;
import java.util.*;
public class Paint2 {
	static int n, q;
	static int[] prefix, suffix;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextInt();
		q = in.nextInt();
		prefix = new int[n];
		suffix = new int[n];
		String s = in.next();
		Stack<Character> activeStrokes = new Stack<Character>();
		activeStrokes.push(s.charAt(0));
		prefix[0] = 1;
		for (int i=1; i<s.length(); i++) {
			prefix[i] = prefix[i-1];
			while (!activeStrokes.isEmpty() && s.charAt(i)<activeStrokes.peek()) {
				activeStrokes.pop();
			}
			if (!activeStrokes.isEmpty() && s.charAt(i)>activeStrokes.peek()) {
				activeStrokes.push(s.charAt(i));
				prefix[i]++;
			}
			if (activeStrokes.isEmpty()) {
				activeStrokes.push(s.charAt(i));
				prefix[i]++;
			}
		}
		activeStrokes = new Stack<Character>();
		activeStrokes.push(s.charAt(n-1));
		suffix[n-1] = 1;
		for (int i=n-2; i>=0; i--) {
			suffix[i] = suffix[i+1];
			while (!activeStrokes.isEmpty() && s.charAt(i)<activeStrokes.peek()) {
				activeStrokes.pop();
			}
			if (!activeStrokes.isEmpty() && s.charAt(i)>activeStrokes.peek()) {
				activeStrokes.push(s.charAt(i));
				suffix[i]++;
			}
			if (activeStrokes.isEmpty()) {
				activeStrokes.push(s.charAt(i));
				suffix[i]++;
			}
			
		}
//		for (int i=0; i<n; i++) {
//			System.out.println(prefix[i]);
//		}
		for (int i=0; i<q; i++) {
			int start = in.nextInt()-1;
			int end = in.nextInt()-1;
			if (start==0 && end==n-1) {
				System.out.println(0);
			}
			else if (start==0) {
				System.out.println(suffix[end+1]);
			}
			else if (end==n-1) {
				System.out.println(prefix[start-1]);
			}
			else System.out.println(prefix[start-1]+suffix[end+1]);
		}
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO() {
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