import java.util.*;

public class Level1 {

    public static int [] MadMax(int N, int [] Tele) {
        Arrays.sort(Tele);
        for (int i = N / 2; i < 3 * N / 4; i++) {
            int temp = Tele[i];
            Tele[i] = Tele[3 * N / 2 - i - 1];
            Tele[3 * N / 2 - i - 1] = temp;
        }
        return Tele;
    }
}

