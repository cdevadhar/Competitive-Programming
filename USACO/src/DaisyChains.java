import java.io.*;
import java.util.*;
public class DaisyChains {
	
	public void countAverageFlowers(ArrayList<Integer> flowers) {
		int count = flowers.size();
		for (int i=0; i<flowers.size(); i++) {
			for (int j=i+1; j<flowers.size(); j++) {
				List<Integer> picture = flowers.subList(i, j+1);
				for (int m=0; m<picture.size(); m++) {
					
				}
				
				double average = new DaisyChains().getAverage(picture);
				int intaverage=1000000000;
				if (average%1==0) {
					intaverage = (int) average;
				}
				
				if (picture.contains(intaverage)) {
					count ++;
					
				}
				
			}
		}
		System.out.println(count);
	}
	
	public double getAverage(List<Integer> list) {
		Integer count = 0;
		for (int i=0; i<list.size(); i++) {
			count += list.get(i);
		}
		return count.doubleValue()/list.size();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> flowers = new ArrayList<Integer>();
		for (int i=0; i<N; i++) {
			int a = scan.nextInt();
			flowers.add(a);
			
		}
		new DaisyChains().countAverageFlowers(flowers);
	}
}
