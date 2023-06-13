import java.io.*;
import java.util.*;

public class iCow {

    public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // #songs
		int T = Integer.parseInt(st.nextToken()); // Determine first T songs
		
		int[] songRatings = new int[N]; // array to store rating of each song
		
		for (int i = 0; i < N; i++)
		{
			songRatings[i] = Integer.parseInt(br.readLine()); // fill the songRatings array
		}

		while (T --> 0)
		{
			//System.out.println(Arrays.toString(songRatings));
			int maxIndex = maxIndex(songRatings); // find index of first maximum value
			int addition = songRatings[maxIndex]/(N-1); // amount to add to each value in the array other than the maximum value
			int leftOver = songRatings[maxIndex]%(N-1); // amount of remainders
			songRatings[maxIndex] = 0; // set the original maximum value to 0
			
			for (int i = 0; i < N; i++)
			{
				if (i != maxIndex)
				{
					songRatings[i] += addition; // add addition to each element in array other than the max value
				}
			}
			if (leftOver != 0) // if there is leftOver
			{
				int index = 0;
				while (leftOver> 0)
				{
					if (index != maxIndex)
					{
						songRatings[index]++;	// add leftovers one by one to the array until used up
						leftOver--;
					}
					index++;
				}
			}
			System.out.println(maxIndex + 1); //output answer
		}
		br.close();
	}
	
	// find the index of the maximum value of the array (return the index of the first one if two maximum values that are the same)
	public static int maxIndex(int[] array)
	{
		int max = array[0];
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}