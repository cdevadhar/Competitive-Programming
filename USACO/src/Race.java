import java.util.*;
import java.io.*;

public class Race {
	
	public void fastestSpeed(int K, int X) {
		int speed=0;
		int distance=0;
		while (distance<K) {
			if (speed<X) {
				speed+=1;
				distance+=speed;
			}
			else {
				distance+=speed;
			}
		}
		System.out.println(speed);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
	}
	

}
