import java.io.*;
import java.util.*;
public class NewYear {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] friends = new int[n];
		int[] count = new int[200001];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			friends[i] = x;
			count[x]++;
		}
		int min = 0;
		int index=0;
		while (index<200001) {
			if (count[index]==0) {
				index++;
				continue;
			}
			else {
				min++;
				index+=3;
			}
		}
		int streak = 0;
		int segmentSum = 0;
		index=0;
		int previous = -1;
		int max=0;
		while (index<200001) {
			if (count[index]==0) {
				if (streak>0) {
					if (segmentSum==streak) {
						max+=streak;
						
					}
					else if (segmentSum==streak+1) {
						if (previous<index-streak-1) {
							max+=(streak+1);
							previous = index-1;
						}
						else {
							max+=(streak+1);
							previous = index;
						}
					}
					else {
						if (previous<index-streak-1) {
							max+=(streak+2);
							previous = index;
						}
						else {
							max+=(streak+1);
							previous = index;
						}
					}
				}
				streak = 0;
				segmentSum=0;
				index++;
				continue;
			}
			
			streak++;
			segmentSum+=count[index];
			index++;
			continue;
		}
		if (streak>0) {
			if (segmentSum==streak) {
				max+=streak;
				
			}
			else if (segmentSum==streak+1) {
				if (previous<index-streak-1) {
					max+=(streak+1);
					previous = index-1;
				}
				else {
					max+=(streak+1);
					previous = index;
				}
			}
			else {
				if (previous<index-streak-1) {
					max+=(streak+2);
					previous = index;
				}
				else {
					max+=(streak+1);
					previous = index;
				}
			}
		}
		System.out.println(min+" "+max);
		
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
