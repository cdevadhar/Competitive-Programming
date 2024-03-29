import java.io.*;
import java.util.*;
public class ClosestCow {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int k = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		ArrayList<Event> events = new ArrayList<Event>();
		for (int i=0; i<k; i++) {
			
			int pos = in.nextInt();
			int taste = in.nextInt();
//			System.out.println(pos + " " + taste);
			events.add(new Event(pos, true, taste));
		}
		for (int i=0; i<m; i++) {
			int pos = in.nextInt();
			events.add(new Event(pos, false, -1));
		}
		Collections.sort(events, (o1, o2) -> Integer.compare(o1.position, o2.position));
		ArrayList<Event> currPatches = new ArrayList<Event>();
		ArrayList<Long> possibleCows = new ArrayList<Long>();
		int index = 0;
		long left = 0;
		long right = 0;
		int cowsSeen = 0;
		long currTaste = 0;
		while (index<events.size()) {
			Event curr = events.get(index);
//			System.out.println(index+" "+events.size());
			if (curr.isPatch) {
//				System.out.println(curr.taste);
				currPatches.add(curr);
				currTaste+=curr.taste;
			}
			else {
				if (cowsSeen==0) {
					possibleCows.add(currTaste);
					currTaste = 0;
					currPatches.clear();
					left = curr.position;
				}
				else {
					
					long taste = maxTaste(left, curr.position, currPatches);
//					if (!currPatches.isEmpty() && taste==0) System.out.println("failed"); 
					possibleCows.add(taste);
//					System.out.println(left+ " " + curr.position);
//					System.out.println("tastes: " + taste+" "+ currTaste);
					possibleCows.add(currTaste-taste);
					left = curr.position;
					currPatches.clear();
					currTaste = 0;
				}
				cowsSeen++;
			}
			index++;
		}
//		System.out.println(currTaste);
		possibleCows.add(currTaste);
		Collections.sort(possibleCows);
		Collections.reverse(possibleCows);
		long sum = 0;
		for (int i=0; i<n && i<possibleCows.size(); i++) {
			sum+=possibleCows.get(i);
		}
		System.out.println(sum);
	}
	public static long maxTaste(long left, long right, ArrayList<Event> patches) {
		if (patches.isEmpty()) return 0;
//		else System.out.println("continuing");
		long maxTaste = 0;
		int front = 0;
		int back = 0;
		long currTaste = patches.get(0).taste;
		while (front<patches.size() && back<patches.size()) {
			double distance = (double)(patches.get(back).position-patches.get(front).position)/2;
//			System.out.println("Distance = " + distance);
			if (distance<patches.get(front).position-left && distance<right-patches.get(back).position) {
				maxTaste = Math.max(maxTaste, currTaste);
				back++;
				if (back<patches.size()) currTaste+=patches.get(back).taste;
			}
			else {
				front++;
				if (front<=patches.size()) currTaste-=patches.get(front-1).taste;
				if (front>back) {
					back++;
					if (back<patches.size()) currTaste+=patches.get(back).taste;
				}
				
			}
		}
//		System.out.println(maxTaste);
		return maxTaste;
	}
	static class Event {
		int position, taste;
		boolean isPatch;
		public Event(int position, boolean isPatch, int taste) {
			this.position = position;
			this.isPatch = isPatch;
			this.taste = taste;
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
