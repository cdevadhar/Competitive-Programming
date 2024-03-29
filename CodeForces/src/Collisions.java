import java.io.*;
import java.util.*;

public class Collisions {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] robotData = new int[n][2];
			int[] ans = new int[n];
			Arrays.fill(ans, -1);
			for (int i=0; i<n; i++) {
				robotData[i][0] = in.nextInt();
			}
			for (int i=0; i<n; i++) {
				String s = in.next();
				if (s.equals("L")) robotData[i][1] = -1;
				else robotData[i][1] = 1;
			}
			ArrayList<Robot> evenRobots = new ArrayList<Robot>();
			ArrayList<Robot> oddRobots = new ArrayList<Robot>();
			for (int i=0; i<n; i++) {
				Robot r = new Robot(robotData[i][0], robotData[i][1], i);
				if (robotData[i][0]%2==0) {
					evenRobots.add(r);
				}
				else oddRobots.add(r);
			}
			Collections.sort(evenRobots, (o1, o2) -> Integer.compare(o1.start, o2.start));
			Collections.sort(oddRobots, (o1, o2) -> Integer.compare(o1.start, o2.start));
			Stack<Robot> rightRobots = new Stack<Robot>();
			for (int i=0; i<evenRobots.size(); i++) {
				if (evenRobots.get(i).direction==1) {
					rightRobots.add(evenRobots.get(i));
				}
				else {
					if (rightRobots.isEmpty()) {
						Robot r = evenRobots.get(i);
						r.start*=(-1);
						rightRobots.add(r);
					}
					else {
						Robot prev = rightRobots.pop();
//						System.out.println(prev.start+" "+evenRobots.get(i).start);
						int answer = (evenRobots.get(i).start-prev.start)/2;
						ans[prev.id] = answer;
						ans[evenRobots.get(i).id] = answer;
					}
				}
			}
			while (rightRobots.size()>=2) {
				Robot first = rightRobots.pop();
				Robot second = rightRobots.pop();
				int collision1 = m-first.start;
				int answer = (m-(second.start+collision1))/2 + collision1;
				ans[first.id] = answer;
				ans[second.id] = answer;
			}
			rightRobots.clear();
			for (int i=0; i<oddRobots.size(); i++) {
				if (oddRobots.get(i).direction==1) {
					rightRobots.add(oddRobots.get(i));
				}
				else {
					if (rightRobots.isEmpty()) {
						Robot r = oddRobots.get(i);
						r.start*=(-1);
						rightRobots.add(r);
					}
					else {
						Robot prev = rightRobots.pop();
						int answer = (oddRobots.get(i).start-prev.start)/2;
						ans[prev.id] = answer;
						ans[oddRobots.get(i).id] = answer;
					}
				}
			}
			while (rightRobots.size()>=2) {
				Robot first = rightRobots.pop();
				Robot second = rightRobots.pop();
				int collision1 = m-first.start;
				int answer = (m-(second.start+collision1))/2+collision1;
				ans[first.id] = answer;
				ans[second.id] = answer;
			}
			for (int i=0; i<n; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}
	}
	static class Robot {
		int start, direction, id;
		public Robot(int start, int direction, int id) {
			this.start = start;
			this.direction = direction;
			this.id = id;
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
