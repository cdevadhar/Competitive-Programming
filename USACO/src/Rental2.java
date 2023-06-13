import java.io.*;
import java.util.*;

public class Rental2 {
	static int n, m, r;
	static int[] cows, rent;
	static Store[] milkOffers;
	static long[] rentProfit;
	static long[] milkProfit;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "rental.out");
		n = in.nextInt();
		m = in.nextInt();
		r = in.nextInt();
		cows = new int[n];
		rent = new int[r];
		
		milkOffers = new Store[m];
		rentProfit = new long[n];
		milkProfit = new long[n];
		for (int i=0; i<n; i++) {
			cows[i] = in.nextInt();

		}
		for (int i=0; i<m; i++) {
			milkOffers[i] = new Store(in.nextInt(), in.nextInt());
		}
		for (int i=0; i<r; i++) {
			rent[i] = in.nextInt();
		
		}
		Arrays.sort(cows);
		Arrays.parallelSort(rent);
		Arrays.parallelSort(milkOffers);
		getRentProfit();
		getMilkProfit();
		long maxProfit = Math.max(milkProfit[0], rentProfit[n-1]);
//		for (int i=n-2; i>=0; i--) {
//			if (milkProfit[i]<milkProfit[i+1]) {
//				System.out.println(milkProfit[i] + " " + milkProfit[i+1]);
//			}
//		}
		for (int i=1; i<n; i++) {
			long currProfit = milkProfit[i]+rentProfit[i-1];
			System.out.println(milkProfit[i] + " " + rentProfit[i-1] + " " + currProfit);
			maxProfit = Math.max(maxProfit, currProfit);
		}
		System.out.println(maxProfit);
	}
	
	public static void getMilkProfit() {
		int currCow = n-1;
		int currMilker = m-1;
		long currProfit;
		while (currCow>=0 && currMilker>=0) {
			currProfit = 0;
			if (milkOffers[currMilker].gallons>=cows[currCow]) {
				milkOffers[currMilker].gallons-=cows[currCow];
				currProfit = cows[currCow]*milkOffers[currMilker].rate;
				
				if (milkOffers[currMilker].gallons==0) {
					currMilker--;
				}
			}
			else {
				currProfit = milkOffers[currMilker].gallons*milkOffers[currMilker].rate;
				cows[currCow]-=milkOffers[currMilker].gallons;
				currMilker--;
				
				while (currMilker>=0) {
					if (milkOffers[currMilker].gallons>=cows[currCow]) {
						milkOffers[currMilker].gallons-=cows[currCow];
						currProfit += cows[currCow]*milkOffers[currMilker].rate;
						
						if (milkOffers[currMilker].gallons==0) {
							currMilker--;
						}
						break;
					}
					else {
						currProfit = milkOffers[currMilker].gallons*milkOffers[currMilker].rate;
						cows[currCow]-=milkOffers[currMilker].gallons;
						currMilker--;
					}
				}
			}
			if (currCow==n-1) {
				milkProfit[currCow] = currProfit;
			}
			else milkProfit[currCow] = currProfit + milkProfit[currCow+1];
			currCow--;
			
		}
		while (currCow>=0) {
			milkProfit[currCow] = milkProfit[currCow+1];
			currCow--;
		}
	}
	public static void getRentProfit() {
		int currCow = 1;
		int currRenter = r-2;
		rentProfit[0] = rent[r-1];
		while (currCow<n && currRenter>=0) {
			rentProfit[currCow] = rentProfit[currCow-1] + rent[currRenter];
			currCow++;
			currRenter--;
		}
		while (currCow<n) {
			rentProfit[currCow] = rentProfit[currCow-1];
			currCow++;
		}
	
	}
	static class Store implements Comparable<Store> {
		int gallons, rate;
		public Store(int gallons, int rate){
			this.gallons = gallons;
			this.rate = rate;
		}
		@Override
		public int compareTo(Store o) {
			// TODO Auto-generated method stub
			return Integer.compare(rate, o.rate);
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
