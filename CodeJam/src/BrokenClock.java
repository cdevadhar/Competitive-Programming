import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class BrokenClock {
	static int t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    t = Integer.parseInt(st.nextToken());
	    for (int i=0; i<t; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	BigInteger handA = new BigInteger(st.nextToken());
	    	BigInteger handB = new BigInteger(st.nextToken());
	    	BigInteger handC = new BigInteger(st.nextToken());
	    	findTime2(handA.longValue(), handB.longValue(), handC.longValue());
	    }
	}
	
	public static void findTime(long handA, long handB, long handC) {
		ArrayList<Double> angles = new ArrayList<Double>();
		double angleA = (handA/12.0)/(Math.pow(10, 10));
		angles.add(angleA);
		double angleB = (handB/12.0)/(Math.pow(10, 10));
		angles.add(angleB);
		double angleC = (handC/12.0)/(Math.pow(10, 10));
		angles.add(angleC);
		System.out.println(angleA + " " + angleB + " " + angleC);
		for (int i=0; i<angles.size(); i++) {
			double seconds = angles.get(i)/6;
			System.out.println(seconds);
			for (int j=0; j<angles.size(); j++) {
				if (i==j) continue;
				double minutes = angles.get(j)/6;
				double secs = (minutes%1)*60;
				if (secs==seconds) {
					for (int k=0; k<angles.size(); k++) {
						if (k==i) continue;
						if (k==j) continue;
						double hours = angles.get(k)/6;
						double mins = ((hours%5)/5)*60;
						if (mins==minutes) {
							System.out.println("hours:" + seconds);
						}
					}
				}
				
			}
		}
		
	}
	
	public static void findTime2(long handA, long handB, long handC) {
		double angleA = (handA/12.0)/(Math.pow(10, 10))/6;
		double angleB = (handB/12.0)/(Math.pow(10, 10))/6;
		double angleC = (handC/12.0)/(Math.pow(10, 10))/6;
		if (angleA == (angleB%1)*60 && angleB == ((angleC%5)/5)*60) {
			System.out.println("Worked!");
			return;
		}
		if (angleA == (angleC%1)*60 && angleC == ((angleB%5)/5)*60) {
			System.out.println("Worked!");
			return;
		}
		if (angleB == (angleA%1)*60 && angleA == ((angleC%5)/5)*60) {
			System.out.println("Worked!");
			return;
		}
		if (angleB == (angleC%1)*60 && angleC == ((angleA%5)/5)*60) {
			System.out.println("Worked!");
			return;
		}
		if (angleC == (angleB%1)*60 && angleB == ((angleA%5)/5)*60) {
			System.out.println("Worked!");
			return;
		}
		if (angleC == (angleA%1)*60 && angleA == ((angleB%5)/5)*60) {
			System.out.println("Worked!");
			return;
		}
		
	}
}
