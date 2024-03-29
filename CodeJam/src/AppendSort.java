import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class AppendSort {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int i=0; i<t; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				long[] array = new long[n];
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					long x = new BigInteger(st.nextToken()).longValue();
					array[j] = x;
				}
				System.out.println("Case #" + (i+1) + ": " + solve(array));
			   
			    
			}
//	    System.out.println(minCurr("93", "931", false));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int solve(long[] array) {
		
		int count = 0;
		for (int i=1; i<array.length; i++) {
			if (array[i]>array[i-1]) continue;
			int prevDigits = String.valueOf(array[i-1]).length();
			int currDigits = String.valueOf(array[i]).length();
			String currString = String.valueOf(array[i]);
			if (currDigits == prevDigits) {
				count++;
				currString = currString.concat("0");
				array[i] = Long.parseLong(currString);
				continue;
			}
			
			for (int j=0; j<prevDigits-currDigits; j++) {
				currString = currString.concat("9");
			}
			long maxCurr = new BigInteger(currString).longValue();
			if (maxCurr>array[i-1]) {
				count += (prevDigits-currDigits);
				array[i] = minCurr(String.valueOf(array[i]), String.valueOf(array[i-1]), false);
			}
			else {
				count += (prevDigits-currDigits) + 1;
				array[i] = minCurr(String.valueOf(array[i]), String.valueOf(array[i-1]), true);
			}
//			array[i] = maxCurr;
		}
		return count;
	}
	
	public static long minCurr(String curr, String prev, boolean moreDigits) {
		boolean canputZeros = false;
		if (moreDigits) {
			int top = (prev.length()-curr.length())+1;
			for (int i=0; i<top; i++) {
				curr = curr.concat("0");
			}
			return new BigInteger(curr).longValue();
		}
		else {
			for (int i=0; i<curr.length(); i++) {
				if (curr.charAt(i)>prev.charAt(i)) {
					canputZeros = true;
				}
			}
			if (canputZeros) {
				int top = (prev.length()-curr.length());
				for (int i=0; i<top; i++) {
					curr = curr.concat("0");
				}
				return Long.parseLong(curr);
			}
			long ans = Long.parseLong(prev)+1;
			return ans;
		}
		
	}
}
