import java.util.*;

public class Level1 {

    public static int [] MadMax(int N, int [] Tele) {
        Arrays.sort(Tele);
        int temp = Tele[N / 2];
        Tele[N / 2] = Tele[N - 1];
        Tele[N - 1] = temp;
        for (int i = N / 2 + 1; i < N - 1; i++) {
            temp = Tele[i];
            Tele[i] = Tele[3 * N / 2 - i - 1];
            Tele[3 * N / 2 - i - 1] = temp;
        }
        return Tele;
    }
}
