import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class lonelyphoto{
	public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int numCows = Integer.parseInt(r.readLine());
		String x = r.readLine();
		char[] cows = x.toCharArray();
		int counter = 0;
		a:
		for (int i = 0; i < numCows; i++){//i is the starting index
			for (int pictureLength = 3; pictureLength + i <= numCows; pictureLength+=1){ //odd numbers cant work
				char[] cowsInPicture = Arrays.copyOfRange(cows, i, i + pictureLength);
				int numGuernsey = 0;
				int numHolstein = 0;
				for (char cow:cowsInPicture){
					numGuernsey += (cow == 'G') ? 1:0;
					numHolstein += (cow == 'H') ? 1:0;
					if (numHolstein > 1 && numGuernsey > 1)
						continue a;
				}
				counter += (numGuernsey == 1 || numHolstein == 1)?1:0;
			}
		}
		System.out.print(counter);
	}
}