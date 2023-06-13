package labs_projects;
public class CopilotTest {
    public static void main(String[] args) {
        streak("abbbbbcd");
    }
    public static void streak(String str) {
        int currStreak=1;
        int maxStreak=0;
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i)==str.charAt(i-1)) currStreak++;
            else currStreak=0;
            if (currStreak>maxStreak) maxStreak=currStreak;

        }

        System.out.println(maxStreak);
    }
}
