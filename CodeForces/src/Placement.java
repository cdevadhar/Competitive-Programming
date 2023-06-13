import java.io.*;
import java.util.*;
public class Placement {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			Person[] widthSort = new Person[n];
			Person[] heightSort = new Person[n];
			for (int i=0; i<n; i++) {
				Person p = new Person(i, in.nextInt(), in.nextInt());
				widthSort[i] = p;
				heightSort[i] = p;
			}
			Arrays.sort(widthSort, (o1, o2) -> Integer.compare(o1.width, o2.width));
			Arrays.sort(heightSort, (o1, o2) -> Integer.compare(o1.height, o2.height));
			Person[] minHeight = new Person[n];
			Person[] minWidth = new Person[n];
			minHeight[0] = widthSort[0];
			minWidth[0] = heightSort[0];
			for (int i=1; i<n; i++) {
				minHeight[i] = minHeight[i-1];
				if (widthSort[i].height<minHeight[i].height) minHeight[i] = widthSort[i];
				minWidth[i] = minWidth[i-1];
				if (heightSort[i].width<minWidth[i].width) minWidth[i] = heightSort[i];
			}
			int[] ans = new int[n];
			Arrays.fill(ans, -2);
			for (int i=0; i<n; i++) {
				int index = binarySearch(widthSort[i].width, widthSort);
				if (index>=0) {
					Person best = minHeight[index];
					if (best.height<widthSort[i].height) {
						ans[widthSort[i].id] = best.id;
						continue;
					}
				}
				int index2 = binarySearch2(widthSort[i].width, heightSort);
				if (index2>=0) {
					Person best =minWidth[index2];
					if (best.width<widthSort[i].height) {
						ans[widthSort[i].id] = best.id;
						continue;
					}
				}
			}
			for (int i=0; i<n; i++) {
				System.out.print(ans[i]+1+" ");
			}
			System.out.println();
		}
	}
	// Returns lowest index whose width is strictly lower than `width`
	public static int binarySearch(int width, Person[] widthSort) {
		if (widthSort[0].width>=width) return -1;
		int hi = widthSort.length-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo+1)/2;
			if (widthSort[mid].width<width) lo=mid;
			else hi = mid-1;
		}
		return hi;
	}
	public static int binarySearch2(int height, Person[] heightSort) {
		if (heightSort[0].height>=height) return -1;
		int hi = heightSort.length-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo+1)/2;
			if (heightSort[mid].height<height) lo=mid;
			else hi = mid-1;
		}
		return hi;
	}
	static class Person {
		int id, width, height;
		public Person(int id, int height, int width) {
			this.id = id;
			this.width = width;
			this.height = height;
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
