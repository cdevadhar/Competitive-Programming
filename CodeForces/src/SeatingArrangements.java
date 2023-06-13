import java.io.*;
import java.util.*;
public class SeatingArrangements {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			ArrayList<Person> sight = new ArrayList<Person>();
			for (int i=0; i<n*m; i++) {
				sight.add(new Person(i, in.nextInt()));
			}
			Collections.sort(sight, (o1, o2) -> {
				if (o1.sight==o2.sight) return Integer.compare(o1.index, o2.index);
				return Integer.compare(o1.sight, o2.sight);
			});
			Person[][] seats = new Person[n][m];
			long inconvenience = 0;
			for (int i=0; i<n; i++) {
				List<Person> row = sight.subList(i*m, i*m+m);
//				List<Person> rowCopy = new ArrayList<Person>();
//				rowCopy.addAll(row);
				Collections.sort(row, (o1, o2) -> {
					if (o1.sight==o2.sight) return Integer.compare(o2.index, o1.index);
					return Integer.compare(o1.sight, o2.sight);
				});
				for (int j=0; j<m; j++) {
					for (int k=0; k<j; k++) {
						if (row.get(k).index<row.get(j).index) inconvenience++;
					}
				}
			}
			System.out.println(inconvenience);
		}
	}
	static class Person {
		int index, sight;
		public Person(int index, int sight) {
			this.index = index;
			this.sight = sight;
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
