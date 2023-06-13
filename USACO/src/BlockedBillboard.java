import java.util.*;
import java.io.*;

public class BlockedBillboard {
	
	public int intersectionArea(ArrayList<Point> a, ArrayList<Point> b) {
		int boardArea = (a.get(1).xvalue - a.get(0).xvalue)*(a.get(1).yvalue - a.get(0).yvalue);
		int overlapX = Math.min(a.get(1).xvalue, b.get(1).xvalue) - Math.max(a.get(0).xvalue, b.get(0).xvalue);
		int overlapY = Math.min(a.get(1).yvalue, b.get(1).yvalue) - Math.max(a.get(0).yvalue, b.get(0).yvalue);
		int overlapArea = 0;
		if (overlapX>0 && overlapY>0) {
			overlapArea = overlapX*overlapY;
		}
		return boardArea-overlapArea;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		ArrayList<Point> billboardA = new ArrayList<Point>();
		ArrayList<Point> billboardB = new ArrayList<Point>();
		ArrayList<Point> truck = new ArrayList<Point>();
		for (int i=0; i<3; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int XA1 = Integer.parseInt(str.nextToken());
			int YA1 = Integer.parseInt(str.nextToken());
			Point bottomLeft = new Point(XA1, YA1);
			int XA2 = Integer.parseInt(str.nextToken());
			int YA2 = Integer.parseInt(str.nextToken());
			Point topRight = new Point(XA2, YA2);
			if (i==0) {
				billboardA.add(bottomLeft);
				billboardA.add(topRight);
			}
			if (i==1) {
				billboardB.add(bottomLeft);
				billboardB.add(topRight);
			}
			if (i==2) {
				truck.add(bottomLeft);
				truck.add(topRight);
			}
			
			
		}
		for (int i=0; i<billboardA.size(); i++) {
			System.out.println(billboardA.get(i).xvalue + ", " + billboardA.get(i).yvalue);
		}
		System.out.println(new BlockedBillboard().intersectionArea(billboardB, truck));
		
		
	}
	
}

class Point {
	int xvalue;
	int yvalue;
	public Point(int xvalue, int yvalue) {
		this.xvalue = xvalue;
		this.yvalue = yvalue;
	}
}
