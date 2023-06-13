import java.io.*;
import java.util.*;
public class Exam {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long time = in.nextLong();
			long a = in.nextLong();
			long b = in.nextLong();
			boolean[] hard = new boolean[n];
			for (int i=0; i<n; i++) {
				hard[i] = in.nextInt()==1;
			}
			Problem[] problems = new Problem[n];
			for (int i=0; i<n; i++) {
				long st = 0;
				if (hard[i]) st=b; else st=a;
				problems[i] = new Problem(st, in.nextLong());
			}
			Arrays.parallelSort(problems, (o1, o2) -> {
				if (o1.mandatory==o2.mandatory) return Long.compare(o1.solveTime, o2.solveTime);
				return Long.compare(o1.mandatory, o2.mandatory);
			});
			long[] prefixTime = new long[n+1];
			long[] suffixEasy = new long[n+1];
			for (int i=0; i<n; i++) {
				prefixTime[i+1] = prefixTime[i]+problems[i].solveTime;
			}
			for (int i=n-1; i>=0; i--) {
				suffixEasy[i] = suffixEasy[i+1];
				if (problems[i].solveTime==a) suffixEasy[i]++;
			}
			long ans = 0;
			for (int e=0; e<n; e++) {
//				if (e>0 && problems[e].mandatory==problems[e-1].mandatory) continue;
				long leaveTime = problems[e].mandatory-1;
				if (prefixTime[e]>leaveTime) {
					continue;
				}
				int solvedMandatory = e;
				long timeLeft = leaveTime-prefixTime[e];
				long easyLeft = suffixEasy[e];
				long hardLeft = n-e-easyLeft;
				long easyTime = easyLeft*a;
				long otherSolved = 0;
				if (easyTime>=timeLeft) {
					otherSolved = timeLeft/a;
				}
				else {
					otherSolved = easyLeft;
					timeLeft-=easyTime;
					if (hardLeft>0)otherSolved+=timeLeft/(hardLeft*b);
				}
				ans = Math.max(ans, solvedMandatory+otherSolved);
			}
			if (prefixTime[n]<=time) ans = n;
			System.out.println(ans);
		}
	}
	static class Problem {
		long solveTime, mandatory;
		public Problem(long solveTime, long mandatory) {
			this.solveTime = solveTime;
			this.mandatory = mandatory;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
