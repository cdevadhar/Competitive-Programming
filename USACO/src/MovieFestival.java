import java.io.*;
import java.util.*;

public class MovieFestival {
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bi.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		for (int i=0; i<k; i++) times.add(0);
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(bi.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Movie movie = new Movie(start, end);
			movies.add(movie);
		}
		Collections.sort(movies);
//		for (int i=0; i<n; i++) {
//			//System.out.println(movies.get(i).start + " " + movies.get(i).end);
//		}
		int count = 0;
//		for (int i=0; i<k; i++) {
//			int currTime = 0;
//			for (int j=0; j<movies.size(); j++) {
//				if (movies.get(j).start>=currTime) {
//					currTime = movies.remove(j).end;
//					j--;
//					//count++;
//				}
//			}
//		}
		
		for (int i=0; i<n; i++) {
			int min = Collections.min(times);
			if (min<=movies.get(i).start) {
				times.set(times.indexOf(min), movies.get(i).end);
				count++;
			}
		}
		System.out.println(count);
		
	}
}

class Movie implements Comparable<Movie>{
	int start, end;
	public Movie(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.end, o.end);
	}
}
