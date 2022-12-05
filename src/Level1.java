import java.util.*;

public class Level1 {

    public static List<String> xxx(int len, String s) {
        List<String> buffer = new ArrayList<>();
        while (s.length() >= len) {
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ' && i > 0) {
                    buffer.add(s.substring(0, i));
                    s = s.substring(s.charAt(i + 1) != ' ' ? i + 1 : i + 2);
                    i = len;
                    if (s.length() <= len) {
                        buffer.add(s);
                        return buffer;
                    }
                }
            }
            buffer.add(s.substring(0, len));
            s = s.substring(s.charAt(len) != ' ' ? len : len + 1);
            if (s.length() <= len && s.length() != 0 && !" ".equals(s)) {
                buffer.add(s);
                return buffer;
            }
        }
        return buffer;
    }

    public static int [] WordSearch(int len, String s, String subs)  {
        ArrayList<Integer> rsl = new ArrayList<>();
        List<String> strings = xxx(len, s);
        System.out.println(strings);
        for (String x : strings) {
            rsl.add(x.matches("(.*)"+ "(\s|^)" + subs+ "(\s|$)" + "(.*)") ? 1 : 0);
            }
        return rsl.stream().mapToInt(i -> i).toArray();
    }
}

