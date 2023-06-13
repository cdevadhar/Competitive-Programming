import java.io.*;
import java.util.*;
// Come back to this tomorrow
public class BusyRobot {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			Command[] commands = new Command[n];
			for (int i=0; i<n; i++) {
				commands[i] = new Command(in.nextInt(), in.nextInt());
			}
			int position  = 0;
			int successful=0;
			int index=0;
			while (index<n) {
//				System.out.println(index);
				int initialTime = commands[index].time;
				int initialTarget = commands[index].target;
				int timeTaken = Math.abs(commands[index].target-position);
				index++;
				successful++;
				if (index<n && commands[index].time<initialTime+timeTaken) successful--;
				
				
				while (index<n && commands[index].time<initialTime+timeTaken) {
					int timeToTarget = Math.abs(commands[index].target-position);
					
					if ((commands[index].target>=position && commands[index].target<=initialTarget) || (commands[index].target<=position && commands[index].target>=initialTarget)) {
						System.out.println(index);
						System.out.println(position + " " + initialTarget);
						if (timeToTarget>=commands[index].time) {
							System.out.println(index);
							boolean works = true;
							if (index<n-1 && timeToTarget>commands[index+1].time) works=false;
							if (works) successful++;
						}
					}
					index++;
				}
				position = initialTarget;
			}
			System.out.println(successful);
		}
	}
	static class Command {
		int time, target;
		public Command(int time, int target) {
			this.time = time;
			this.target = target;
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
