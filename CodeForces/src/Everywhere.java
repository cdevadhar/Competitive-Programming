import java.io.*;
import java.util.*;

public class Everywhere {
	static int n;
	static char[] house;
	static Map<Character, Integer> charCount;
	static Map<Character, Integer> removedCharCount;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		house = new char[n];
		charCount = new HashMap<Character, Integer>();
		removedCharCount = new HashMap<Character, Integer>();
		String s = in.next();
		for (int i=0; i<n; i++) {
			house[i] = s.charAt(i);
			if (charCount.containsKey(s.charAt(i))) {
				charCount.put(s.charAt(i), charCount.get(s.charAt(i))+1);
			}
			charCount.putIfAbsent(s.charAt(i), 1);
		}
		int right = n-1;
		int left = 0;
		boolean done = false;
		while (!done) {
			if (removedCharCount.containsKey(s.charAt(right))) {
				if (removedCharCount.get(s.charAt(right))!=charCount.get(s.charAt(right))-1) {
					removedCharCount.put(s.charAt(right),removedCharCount.get(s.charAt(right))+1);
					right--;
				}
				else done=true;
			}
			else {
				if (charCount.get(s.charAt(right))==1) {
					done = true;
				}
				else {
					removedCharCount.put(s.charAt(right), 1);
					right--;
				}
			}
		}
		done = false;
		while (!done) {
			if (removedCharCount.containsKey(s.charAt(left))) {
				if (removedCharCount.get(s.charAt(left))!=charCount.get(s.charAt(left))-1) {
					removedCharCount.put(s.charAt(left),removedCharCount.get(s.charAt(left))+1);
					left++;
				}
				else done=true;
			}
			else {
				if (charCount.get(s.charAt(left))==1) {
					done = true;
				}
				else {
					removedCharCount.put(s.charAt(left), 1);
					left++;
				}
			}
		}
		System.out.println(right-left+1);
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
