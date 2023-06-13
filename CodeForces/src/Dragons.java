import java.io.*;
import java.util.*;
public class Dragons {
	
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] heroes = new int[n];
		int sum = 0;
		for (int i=0; i<n; i++) {
			heroes[i] = in.nextInt();
			sum+=heroes[i];
		}
		Arrays.parallelSort(heroes);
		int m = in.nextInt();
		for (int i=0; i<m; i++) {
			int defense = in.nextInt();
			int attack = in.nextInt();
			int case1 = findHero(defense, heroes);
			int coins1 = -1;
			if (case1>0) {
				coins1 = Math.max(0, attack-(sum-heroes[case1]));
			}
			int case2 = findHero2(defense, heroes);
			int coins2 = -1;
			if (case2>1) {
				coins2 = (defense-heroes[case2]) + Math.max(0, attack-(sum-heroes[case2]));
			}
			if (coins1<0) System.out.println(coins2);
			else if (coins2<0) System.out.println(coins1);
			else System.out.println(Math.min(coins1, coins2));
			
		}
		int[] test = {1,2,3,6,7,8};
		System.out.println(findHero2(5, test));
	}
	
	public static int findHero(int defense, int[] heroes) {
		if (heroes[heroes.length-1]<defense) return -1;
		int high = heroes.length-1;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			if (heroes[mid]<defense) low = mid+1;
			else high = mid;
		}
		return low;
	}
	public static int findHero2(int defense, int[] heroes) {
		if (heroes[0]>=defense) return -1;
		int high = heroes.length-1;
		int low = 0;
		while (high>low) {
			int mid = (high+low+1)/2;
			if (heroes[mid]<defense) low = mid;
			else high = mid-1;
		}
		return low;
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
