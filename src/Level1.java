import java.util.*;

public class Level1 {

    public static String TheRabbitsFoot(String s, boolean encode)  {
        StringBuilder buffer = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (x != ' ') {
                buffer.append(x);
            }
        }
        int n = (int) Math.sqrt(buffer.length());
        int m = (int) Math.ceil(Math.sqrt(buffer.length()));
        if (n * m < buffer.length()) {
            n++;
        }
        if (!encode) {
            int temp = n;
            n = m;
            m = temp;
        }
        char[][] nm = new char[n][m];
        for (int i = 0; i < n; i++) {
            buffer.getChars(m * i, Math.min(m * (i + 1), buffer.length()), nm[i],0);
        }
        StringBuilder buffer2 = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nm[j][i] != 0) {
                    buffer2.append(nm[j][i]);
                }
            }
            if (encode && i != m - 1) {
                buffer2.append(" ");
            }
        }
        return buffer2.toString();
    }
}
