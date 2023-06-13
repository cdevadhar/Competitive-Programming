import java.io.*;
import java.util.*;
public class MilkMeasurement {
	static int BessieMilk = 7;
	static int ElsieMilk = 7;
	static int MildredMilk = 7;
	static ArrayList<String> leaderboard = new ArrayList<String>();
	
	public int simulate(ArrayList<Update> updates) {
		leaderboard.add("Bessie");
		leaderboard.add("Elsie");
		leaderboard.add("Mildred");
		int count=0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<updates.size(); j++) {
				if (updates.get(j).day==i) {
					if (updates.get(j).name.contentEquals("Bessie")) {
						BessieMilk += updates.get(j).change;
					}
					if (updates.get(j).name.contentEquals("Elsie")) {
						ElsieMilk += updates.get(j).change;
					}
					if (updates.get(j).name.contentEquals("Mildred")) {
						MildredMilk += updates.get(j).change;
					}
					int max = Math.max(MildredMilk, Math.max(BessieMilk, ElsieMilk));
					
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Update> updates = new ArrayList<Update>();
		for (int i=0; i<N; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(line.nextToken());
			String name = line.nextToken();
			int change = Integer.parseInt(line.nextToken());
			Update update = new Update(day, name, change);
			updates.add(update);
		}
		
		
	}
}

class Update {
	int day;
	String name;
	int change;
	public Update(int day, String name, int change) {
		this.day=day;
		this.name=name;
		this.change=change;
	}
}
