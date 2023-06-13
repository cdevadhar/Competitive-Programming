import java.io.*;
import java.util.*;
public class Emails {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			int[] f = new int[n+1];
			for (int i=0; i<n; i++) {
				f[i+1] = in.nextInt();
			}
			int[] suffixMin = new int[n+1];
			suffixMin[n] = f[n];
			for (int i=n-1; i>=0; i--) {
				suffixMin[i] = Math.min(f[i], suffixMin[i+1]);
			}
			int startingPoint = suffixMin[1];
//			int minRemaining = Integer.MAX_VALUE;
			ArrayList<Integer> remaining = new ArrayList<Integer>();
			for (int i=0; i<n; i++) {
				startingPoint = suffixMin[i+1];
				if (!(f[i+1]<startingPoint+k)) {
					remaining.add(f[i+1]);
					System.out.println(f[i+1]+" "+suffixMin[i+1]);
				}
				
			}
			boolean works = true;
			// We can see the last k emails of the ones that remain
			// and as we delete, we can see more
			// We know all these emails are below the 
			if (remaining.size()>0) {
				
				Collections.reverse(remaining);
				System.out.println(remaining.size());
				PriorityQueue<Integer> currEmails = new PriorityQueue<Integer>();
				for (int i=0; i<remaining.size() && i<k; i++) {
					
					currEmails.add(remaining.get(i));
				}
//				System.out.println(currEmails.size());
				int index = k;
				while (!currEmails.isEmpty()) {
					System.out.println(currEmails.peek()+" "+startingPoint);
					if (currEmails.peek()<startingPoint) {
						
						works = false;
						break;
					}
					if (currEmails.peek()<startingPoint+k) {
						currEmails.poll();
						if (index<remaining.size()) {
							currEmails.add(remaining.get(index));
							index++;
						}
					}
					else {
						startingPoint = currEmails.peek();
					}
				}
			}
			
			if (!works) System.out.println("NO");
			else System.out.println("YES");
			
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
