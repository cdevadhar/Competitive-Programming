import java.io.*;
import java.util.*;
public class CitiesStates {
	static int n;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("USACOinput1", "citystate.out");
		n = in.nextInt();
		HashMap<String, Integer> specialPairs = new HashMap<String, Integer>();
		String[] cities = new String[n];
		for (int i=0; i<n; i++) {
			String s = in.nextLine();
			String city = s.substring(0, 2);
			String state = s.substring(s.length()-2);
			if (!city.equals(state)) {
				if (specialPairs.containsKey(city+state)) {
					specialPairs.put(city+state, specialPairs.get(city+state)+1);
				}
				else specialPairs.put(city+state, 1);
			}
			cities[i] = city+state;
		}
		int count=0;
		for (int i=0; i<n; i++) {
			String city = cities[i].substring(0, 2);
			String state = cities[i].substring(cities[i].length()-2);
			if (!city.equals(state)) {
				if (specialPairs.containsKey(state+city)) {
					count+=specialPairs.get(state+city);
				}
			}
		}
		System.out.println(count/2);
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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