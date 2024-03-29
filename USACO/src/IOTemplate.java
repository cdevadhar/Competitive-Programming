import java.io.*;
import java.util.*;
public class IOTemplate {
	BufferedReader br;
    StringTokenizer st;

    public IOTemplate()
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
