import java.io.*;
import java.util.*;
public class Running {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int roads = 4*n*m-2*n-2*m;
		if (k>roads) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
			ArrayList<String> ans = new ArrayList<String>();
			int count = 0;
			for (int i=0; i<m-2; i++) {
				if (count==k) {
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				ans.add("1 R");
				count++;
				if (count==k) {
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				if (count+n-1>=k) {
					ans.add(k-count+" D");
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				else {
					ans.add(n-1+" D");
					count+=n-1;
				}
				if (count==k) {
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				if (count+n-1>=k) {
					ans.add(k-count+" U");
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				else {
					ans.add(n-1+" U");
					count+=n-1;
				}
			}
			if (count==k) {
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			ans.add("1 R");
			count++;
			for (int i=0; i<n-2; i++) {
				if (count==k) {
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				ans.add("1 D");
				count++;
				if (count==k) {
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				if (count+m-1>=k) {
					ans.add(k-count+" L");
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				
				else {
					ans.add(m-1+" L");
					count+=m-1;
				}
				if (count==k) {
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				if (count+m-1>=k) {
					ans.add(k-count+" R");
					System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
				}
				else {
					ans.add(m-1+" R");
					count+=m-1;
				}
			}
			if (count==k) {
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			ans.add("1 D");
			count++;
			if (count==k) {
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			if (count+m-1>=k) {
				ans.add(k-count+" L");
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			
			else {
				ans.add(m-1+" L");
				count+=m-1;
			}
			if (count+n-1>=k) {
				ans.add(k-count+" U");
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			else {
				ans.add(n-1+" U");
				count+=n-1;
			}
			if (count+m-1>=k) {
				ans.add(k-count+" R");
			}
			else {
				ans.add(m-1+" R");
				count+=m-1;
			}
			if (count+n-1>=k) {
				ans.add(k-count+" U");
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			else {
				ans.add(n-1+" U");
				count+=n-1;
			}
			if (count+m-1>=k) {
				ans.add(k-count+" L");
				System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
			}
			
			else {
				ans.add(m-1+" L");
				count+=m-1;
			}
			System.out.println(ans.size()); for (String s: ans) System.out.println(s); return;
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
