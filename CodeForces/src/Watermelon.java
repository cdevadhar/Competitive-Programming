import java.io.*;
import java.util.*;
public class Watermelon{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    if (n%2==0 && n>2) System.out.println("YES");
	    else System.out.println("NO");
	}
	
    
}
