import java.io.*;
import java.util.*;
public class MagazineAd {
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    k = Integer.parseInt(st.nextToken());
	    String s = br.readLine();
	    
	    search(s);
	}
	
	public static void search(String s) {
		int high = 1000000;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			if (canFit(mid, s)) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(high);
	}
	
	public static boolean canFit(int maxWidth, String s) {
		int lines = 1;
		int currWidth = 0;
		for (int i=0; i<s.length(); i++) {
			currWidth++;
			if (currWidth==maxWidth) {
				int latest = latestWrapPoint(s, i);
				if (latest==-1) return false;
				lines++;
				currWidth=0;
				i = latest+1;
			}
		}
		if (lines<=k) return true;
		return false;
	}
	
	public static int latestWrapPoint(String s, int index) {
		for (int i=index; i>=0; i--) {
			if (s.charAt(i)=='-' || s.charAt(i)==' ') {
				return i;
			}
		}
		return -1;
	}
}
