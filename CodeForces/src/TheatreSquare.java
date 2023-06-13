import java.io.*;
import java.util.*;
public class TheatreSquare {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    long n = Integer.parseInt(st.nextToken());
	    long m = Integer.parseInt(st.nextToken());
	    long a = Integer.parseInt(st.nextToken());
	    long wide = n + (a-n%a);
	    if (n%a==0) wide = n;
	    long len = m + (a-m%a);
	    if (m%a==0) len = m;
	    System.out.println(wide*len/(a*a));
	}
}
