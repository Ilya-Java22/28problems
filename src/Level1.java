import java.util.*;

public class Level1 {

    public static double len(int a, int b) {
        double rsl = 1;
        if (Math.abs(b - a) == 2 || Math.abs(b - a) == 7) {
            rsl = Math.sqrt(2);
        }
        if (Math.abs(b - a) == 4 && (b != 3 && b != 7)) {
            rsl = Math.sqrt(2);
        }
        if (Math.abs(b - a) == 5 && (b != 1 && b != 6)) {
            rsl = Math.sqrt(2);
        }
        return rsl;
    }

    public static String PatternUnlock(int N, int [] hits) {
        double sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += len(hits[i], hits[i + 1]);
        }
        String a = String.valueOf(Math.round(sum * 100000));
        char[] b = new char[a.length()];
        int newSize = 0;
        int i = 0;
        for (char ch : a.toCharArray()) {
            if (ch != '0') {
                b[i] = ch;
                newSize++;
                i++;
            }
        }
        return new String(Arrays.copyOf(b, newSize));
    }
}

