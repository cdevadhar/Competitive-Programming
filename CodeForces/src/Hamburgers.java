import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hamburgers {
	static int numB, numS, numC;
	static int initialB, initialS, initialC;
	static int priceB, priceS, priceC;
	static long money;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		String s = in.next();
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)=='B') numB++;
			if (s.charAt(i)=='S') numS++;
			if (s.charAt(i)=='C') numC++;
		}
//		System.out.println(numB + " " + numS + " " + numC);
		initialB = in.nextInt();
		initialS = in.nextInt();
		initialC = in.nextInt();
		priceB = in.nextInt();
		priceS = in.nextInt();
		priceC = in.nextInt();
		money = in.nextLong();
		long high = 10000000000000L;
		long low = 0;
		while (high>low) {
			long mid = (high+low+1)/2;
			if (canMake(mid)) low = mid;
			else high = mid-1;
		}
		
		System.out.println(high);
	}
	
	public static boolean canMake(long burgers) {
		long bNeeded = Math.max(0,numB*burgers-initialB);
		long sNeeded = Math.max(0, numS*burgers-initialS);
		long cNeeded = Math.max(0, numC*burgers-initialC);
//		System.out.println(bNeeded+ " " + sNeeded + " " + cNeeded);
		long totalPrice = (priceB*bNeeded+priceS*sNeeded+priceC*cNeeded);
//		System.out.println(totalPrice);
		if (totalPrice>money) return false;
		return true;
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
