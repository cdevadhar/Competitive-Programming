import java.io.*;
import java.util.*;

public class Inconvenient {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			boolean[] vert = new boolean[1000001];
			boolean[] horiz = new boolean[1000001];
			ArrayList<Integer> vertList = new ArrayList<Integer>();
			ArrayList<Integer> horizList = new ArrayList<Integer>();
			ArrayList<Person> vertPeople = new ArrayList<Person>();
			ArrayList<Person> horizPeople = new ArrayList<Person>();
			for (int i=0; i<n; i++) {
				int x = in.nextInt();
				vert[x] = true;
				vertList.add(x);
			}
			for (int i=0; i<m; i++) {
				int y = in.nextInt();
				horiz[y] = true;
				horizList.add(y);
			}
			Collections.sort(horizList);
			Collections.sort(vertList);
			for (int i=0; i<k; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				Person p = new Person(x, y);
				if (vert[x] && !horiz[y]) {
					vertPeople.add(p);
				}
				if (horiz[y] && !vert[x]) {
					horizPeople.add(p);
				}
			}
			Collections.sort(vertPeople, (o1, o2) -> {
				if (o1.y==o2.y) return Integer.compare(o1.x, o2.x);
				return Integer.compare(o1.y, o2.y);
			});
			Collections.sort(horizPeople, (o1, o2) -> {
				if (o1.x==o2.x) return Integer.compare(o1.y, o2.y);
				return Integer.compare(o1.x, o2.x);
			});
			HashMap<Integer, Integer> active = new HashMap<Integer, Integer>();
			long numActive = 0;
			int prev = 0;
			long horizAns = 0;
			for (int i=0; i<horizPeople.size(); i++) {
				// First check the prefix of new x and previous to see if there was a vertical road between
				// If there was, clear the active map and set numActive to zero
				if (Collections.binarySearch(vertList, horizPeople.get(i).x)!=Collections.binarySearch(vertList, prev)) {
					active = new HashMap<Integer, Integer>();
					numActive = 0;
				}
				//add the new person to the active map - stored based on which road they're on
				active.putIfAbsent(horizPeople.get(i).y, 0);
				active.put(horizPeople.get(i).y, active.get(horizPeople.get(i).y)+1);
				numActive++;
				//now find how many active people are on different roads and add that to the answer
				horizAns+=numActive-active.get(horizPeople.get(i).y);
				//update prev and continue
				prev = horizPeople.get(i).x;
			}
			active = new HashMap<Integer, Integer>();
			numActive=0;
			prev = 0;
			long vertAns = 0;
			for (int i=0; i<vertPeople.size(); i++) {
				if (Collections.binarySearch(horizList, vertPeople.get(i).y)!=Collections.binarySearch(horizList, prev)) {
					active = new HashMap<Integer, Integer>();
					numActive = 0;
				}
				active.putIfAbsent(vertPeople.get(i).x, 0);
				active.put(vertPeople.get(i).x, active.get(vertPeople.get(i).x)+1);
				numActive++;
				
				vertAns+=numActive-active.get(vertPeople.get(i).x);
//				System.out.println("vertAns: " + vertAns);
				prev = vertPeople.get(i).y;
			}
			System.out.println(vertAns+horizAns);
		}
	}
	static class Person {
		int x, y;
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
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
