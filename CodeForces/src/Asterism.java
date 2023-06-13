import java.io.*;
import java.util.*;
public class Asterism
{
    public static void main(String[] args) throws Exception {
        FastIO in = new FastIO();
 
        int n = in.nextInt();
        long p = in.nextLong();
 
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
        	a[i] = in.nextInt();
        }
        Arrays.sort(a);
 
        long[] numl = new long[4001];
        int k = 1;
        for (int i = 0; i < n; i++)
        {
            while(a[i] > k)
            {
                numl[k] = i;
                k++;
            }
        }
        for (int i = a[n-1]; i <= 4000; i++) {
        	numl[i] = a.length;
        }
            
 
        ArrayList<Integer> res = new ArrayList<>();
        for (int x = 1; x <= 2000; x++) {
            int cx = x;
            boolean val = true;
            for (int i = 0; i < n; i++) {
            	if ((numl[cx++]-i)%p==0) {
            		val = false;
                }
            }    
            if (val) {
            	res.add(x);
            }
             
        }
 
        System.out.println(res.size());
        for(int x : res)
            System.out.print(x + " ");
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

