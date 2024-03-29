import java.io.*;
import java.util.*;
public class Armchairs {
	// There is some bug here, but the full sol has a lot of dp so come back to it
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] armchairs = new int[n];
		for (int i=0; i<n; i++) {
			armchairs[i] = in.nextInt();
		}
		int[] curr = armchairs.clone();
		long ans = 0;
		for (int i=0; i<n; i++) {
			if (armchairs[i]==0) continue;
			int currIndex=i-1;
			int closestLeft = Integer.MAX_VALUE;
			int closestRight = Integer.MAX_VALUE;
			while (currIndex>0) {
				if (curr[currIndex]==0 && armchairs[currIndex]==0) {
					closestLeft = i-currIndex;
					break;
				}
				currIndex--;
			}
			currIndex = i+1;
			while (currIndex<n) {
				if (curr[currIndex]==0 && armchairs[currIndex]==0) {
					closestRight = currIndex-i;
					break;
				}
				currIndex++;
			}
//			System.out.println(closestLeft+" "+closestRight);
			if (closestLeft<=closestRight) {
				curr[i-closestLeft] = 1;
				curr[i] = 0;
				ans+=closestLeft;
			}
			else {
				curr[i+closestRight] = 1;
				curr[i] = 0;
				ans+=closestRight;
			}
		}
		System.out.println(ans);
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
