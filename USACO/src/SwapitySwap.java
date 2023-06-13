import java.util.*;
import java.io.*;
public class SwapitySwap {
	static int n, m, k;
	static int[] nums;
	static boolean[] visited;
	static int[] answers;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("swap.in", "swap.out");
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		nums = new int[n];
		visited = new boolean[n];
		answers = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = i;
		}
		for (int i=0; i<m; i++) {
			int start = in.nextInt()-1;
			int end = in.nextInt()-1;
			swap(start, end);
		}

		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				ArrayList<Integer> component = traverse(i, new ArrayList<Integer>());
				for (int j=0; j<component.size(); j++) {
					int newIndex = (j+k)%component.size();
					answers[component.get(j)] = component.get(newIndex);
				}
			}
		}

		for (int i=0; i<n; i++) {
			in.pr.println(answers[i]+1);
		}
		in.pr.close();
	}
	public static ArrayList<Integer> traverse(int node, ArrayList<Integer> component) {
		if (visited[node]) return component;
		visited[node] = true;
		component.add(node);
//		System.out.println(node);
		component = traverse(nums[node], component);
		return component;
	}
	public static void swap(int startIndex, int endIndex) {
		int[] temp = Arrays.copyOfRange(nums, startIndex, endIndex+1);
		int end = temp.length-1;
		for (int i=0; i<temp.length/2; i++) {
			int x = temp[i];
			temp[i] = temp[end];
			temp[end] = x;
			end--;
		}
		for (int i=startIndex; i<endIndex+1; i++) {
			nums[i] = temp[i-startIndex];
		}
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


