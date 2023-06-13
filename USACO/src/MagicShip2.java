import java.io.*;
import java.util.*;
public class MagicShip2 {
	static int x1, y1, x2, y2, n;
	static String s;
	static int[][] prefix;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		x1 = in.nextInt();
		y1=in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		n = in.nextInt();
//		System.out.println(n);
		s = in.nextLine();
		prefix=new int[n+1][2];
		prefix[0][0] = x1;
		prefix[0][1] = y1;
		for (int i=1; i<n+1; i++) {
			char c = s.charAt(i-1);
			prefix[i][0] = prefix[i-1][0];
			prefix[i][1] = prefix[i-1][1];
			if (c=='U') prefix[i][1]++;
			else if (c=='D') prefix[i][1]--;
			else if (c=='R') prefix[i][0]++;
			else if (c=='L') prefix[i][0]--;
		}
		
		for (int i=0; i<10; i++) {
			System.out.println(canReach(i));
		}
		System.out.println(canReach(4));
		System.out.println(search());
		
	}
	public static int search() {
		int high=100;
		int low=0;
		if (!canReach(high)) return -1;
		while (high>low) {
			int mid = (high+low)/2;
			if (canReach(mid)) high=mid;
			else low=mid+1;
		}
		return low;
	}
	
	public static boolean canReach(int days) {
		int tempx=x1;
		int tempy=y1;
		if (days<=n) {
			tempx=prefix[days][0];
			tempy=prefix[days][1];
		}
		else {
			int index = days%n;
//			System.out.println(index);
			tempx = (days/n)*prefix[n][0] + (prefix[index][0]-x1);
//			System.out.println(tempx);
//			System.out.println(prefix[n][1]);
			tempy = (days/n)*prefix[n][1] + (prefix[index][1]-y1);
		}
//		System.out.println(tempx+" " + tempy);
		
		int distanceX = Math.abs(x2-tempx);
		int distanceY = Math.abs(y2-tempy);
		if ((distanceX+distanceY)<=days) return true;
		return false;
		
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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
