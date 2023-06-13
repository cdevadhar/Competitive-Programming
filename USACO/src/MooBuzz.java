import java.io.*;
import java.util.*;

public class MooBuzz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int cycles = n/8;
	    int leftover = n%8;
	    if (leftover>0) {
	    	int count=0;
	    	int numbers = 0;
	    	while (numbers<leftover) {
	    		if (count%3!=0 && count%5!=0) numbers++;
		    	count++;
	    	}
	    	pr.println(cycles*15 + count-1);
	    	pr.close();
	    }
	    else {
	    	pr.println(cycles*15-1);
	    	pr.close();
	    }
//	    int numbers = 0;
//	    int count = 1;
//	    while (numbers<n) {
//	    	if (count%3!=0 && count%5!=0) numbers++;
//	    	count++;
//	    }
//	    pr.println(count-1);
//	    pr.close();
	}
}
