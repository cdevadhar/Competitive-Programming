import java.io.*;
import java.util.*;
public class Exam2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			in.nextLine();
			int n = in.nextInt();
			int d = in.nextInt();
			int[] exams = new int[n];
			int[] rest = new int[n+1];
			int prev = 0;
			for (int i=0; i<n; i++) {
				exams[i] = in.nextInt();
				rest[i] = exams[i]-prev-1;
				prev = exams[i];
			}
			rest[n] = d-exams[n-1];
			int hi = d;
			int lo = 0;
			while (hi>lo) {
				int mid = (hi+lo+1)/2;
				if (canFit(exams, rest, mid, n)) lo = mid;
				else hi = mid-1;
			}
			System.out.println(hi);
		}
	}
	public static boolean canFit(int[] exams, int[] rest, int minGap, int n) {
		boolean move = false;
		boolean placed = false;
		int chosen = -1;
		int prev = 0;
		int biggestGap = 0;
		boolean random = false;
		for (int i=0; i<n; i++) {
			if (move) {
				if (i==chosen+1) {
					if (rest[i]+rest[i-1]+1<minGap) {
//						System.out.println("a");
						return false;
					}
					if (rest[i]<minGap) random = true;
					continue;
				}
				if (rest[i]<minGap) return false;
				if (rest[i]-1>=2*minGap) {
					placed = true;
				}
			}
			else {
				if (rest[i]<minGap) {
					move = true;
					chosen = i;
//					System.out.println(rest[i+1]);
//					System.out.println(i);
					if (i<n-1) {
						if (rest[i+1]+rest[i]>=2*minGap) {
							placed = true;
							continue;
//							System.out.println("a");
						}
					}
					
					if (biggestGap-1>=2*minGap) {
						placed = true;
						continue;
//						System.out.println("c");
					}
					
				}
			}
			biggestGap = Math.max(biggestGap, rest[i]);
		}
		
		if (move && !placed) {
//			System.out.println(chosen);
//			System.out.println(rest[n]);
			if (rest[n]-1>=minGap) placed = true;
			if (chosen>0 && rest[chosen]+rest[chosen-1]>=2*minGap) 
				if (!random) placed = true;
		}
//		System.out.println(move+" "+placed);
		if (!move || placed) return true;
		return false;
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

	    public long nextLong() throws NumberFormatException, IOException {return Long.parseLong(next()); }

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
