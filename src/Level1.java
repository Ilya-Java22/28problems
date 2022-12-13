import java.util.*;

public class Level1 {

    public static String MassVote(int N, int[] Votes) {
        if (N == 1) {
            return "majority winner 1";
        }
        int[] origin = Arrays.copyOf(Votes, N);
        Arrays.sort(Votes);
        if (Votes[N - 1] == Votes[N - 2]) {
            return "no winner";
        }
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (origin[i] == Votes[N - 1]) {
                index = i;
                break;
            }
        }
        int sum = 0;
        for (int x : Votes) {
            sum += x;
        }
        if (Math.round(100000.0 * Votes[N - 1] / sum) > 50000) {
            return "majority winner " + (index + 1);
        } else {
            return "minority winner " + (index + 1);
        }
    }
}
