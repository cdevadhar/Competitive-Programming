import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class exampleSolution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("bcount.in"));
        PrintWriter out = new PrintWriter("bcount.out");

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] Holsteins = new int[N + 1];
        int[] Guernseys = new int[N + 1];
        int[] Jerseys = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            Holsteins[i] += Holsteins[i - 1];
            Guernseys[i] += Guernseys[i - 1];
            Jerseys[i] += Jerseys[i - 1];

            int breed = sc.nextInt();

            if (breed == 1) {
                Holsteins[i] ++;
            } else if (breed == 2) {
                Guernseys[i] ++;
            } else if (breed == 3) {
                Jerseys[i] ++;
            } else {
                System.out.println("What the...");
            }
        }

        for (int i = 0; i < Q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int Holstein = Holsteins[end] - Holsteins[start - 1];
            int Guernsey = Guernseys[end] - Guernseys[start - 1];
            int Jersey = Jerseys[end] - Jerseys[start - 1];

            out.println(Holstein + " " + Guernsey + " " + Jersey);
        }

        sc.close();
        out.close();
    }
}
