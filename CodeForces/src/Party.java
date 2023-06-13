import java.io.*;
import java.util.*;
public class Party {

	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			Person[] people = new Person[n];
			for (int j=0; j<n; j++) {
				int maxRicher = in.nextInt();
				int maxPoorer = in.nextInt();
				Person p = new Person(j, maxRicher, maxPoorer);
				people[j] = p;
				
			}
			int high = n;
			int low = 0;
			while (high>low) {
				int mid = (high+low+1)/2;
				if (canInvite(mid, people)) low = mid;
				else high = mid-1;
			}
			System.out.println(high);
//			System.out.println(canInvite(4, people));
		}
	}
	
	public static boolean canInvite(int numPeople, Person[] people) {
		int num = 0;
		int currRicher = numPeople-1;
		int currPoorer = 0;
		for (int i=0; i<people.length; i++) {
			if (people[i].maxRicher>=currRicher && people[i].maxPoorer>=currPoorer) {
				num++;
				currRicher--;
				currPoorer++;
				if (currRicher==-1) break;
			}
		}
		if (num<numPeople) return false;
		return true;
	}
	static class Person {
		int money, maxRicher, maxPoorer;
		public Person(int money, int maxRicher, int maxPoorer) {
			this.money = money;
			this.maxRicher = maxRicher;
			this.maxPoorer = maxPoorer;
		}
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
