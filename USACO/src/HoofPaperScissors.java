import java.util.*;
import java.io.*;
public class HoofPaperScissors {
	static int N;
	static Scanner in;
	static int[] hoofPrefix;
	static int[] paperPrefix;
	static int[] scissorsPrefix;
	static char[] farmerJohn;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		N = in.nextInt();
		farmerJohn = new char[N];
		hoofPrefix = new int[N+1];
		paperPrefix = new int[N+1];
		scissorsPrefix = new int[N+1];
		for (int i=0; i<N; i++) {
			farmerJohn[i] = in.next().charAt(0);
			hoofPrefix[i] = 0;
			paperPrefix[i] = 0;
			scissorsPrefix[i] = 0;
		}
		fillPrefixes();
		for (int i=0; i<N+1; i++) {
			System.out.print("Hoof: " + hoofPrefix[i] + " ");
			System.out.print("Paper: " + paperPrefix[i] + " ");
			System.out.print("Scissors: " + scissorsPrefix[i] + " ");
			System.out.println();
		}
		System.out.println(getStrat());
		
	}
	
	public static void fillPrefixes() {
		for (int i=0; i<N; i++) {
			hoofPrefix[i+1] = hoofPrefix[i];
			paperPrefix[i+1] = paperPrefix[i];
			scissorsPrefix[i+1] = scissorsPrefix[i];
			if (farmerJohn[i] == 'H') {
				paperPrefix[i+1]++;
			}
			if (farmerJohn[i] =='P' ) {
				scissorsPrefix[i+1]++;
			}
			if (farmerJohn[i] == 'S') {
				hoofPrefix[i+1]++;
			}
		}
	}
	
	public static int getStrat() {
		int maxWins=0;
		for (int i=0; i<N; i++) {
			int beforeSwitch = Integer.max(Integer.max(hoofPrefix[i+1], paperPrefix[i+1]), scissorsPrefix[i+1]);
			int afterSwitch  = Integer.max(Integer.max(hoofPrefix[N]-hoofPrefix[i+1], paperPrefix[N]-paperPrefix[i+1]),scissorsPrefix[N]-scissorsPrefix[i+1]);
			int stratWins = beforeSwitch+afterSwitch;
			if (stratWins>maxWins) maxWins=stratWins;
		}
		return maxWins;
	}

}
