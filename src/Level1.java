import java.util.*;

public class Level1 {

    public static List<String> xxx(int len, String s) {
        List<String> buffer = new ArrayList<>();
        while (s.length() > len) {
            if (s.charAt(len - 1) == ' ') {
                buffer.add(s.substring(0, len - 1));
                s = s.substring(len);
            } else if (s.charAt(len) == ' ') {
                buffer.add(s.substring(0, len));
                s = s.substring(len + 1);
            } else if (s.charAt(len) != ' ') {
                boolean k = true;
                for (int i = len - 2; i > 0; i--) {
                    if (s.charAt(i) == ' ') {
                        buffer.add(s.substring(0, i));
                        s = s.substring(i + 1);
                        k = false;
                        break;
                    }
                }
                if (k) {
                    buffer.add(s.substring(0, len));
                    s = s.substring(len);
                }
            }
        }
        buffer.add(s);
        buffer.removeAll(Arrays.asList(""));
        return buffer;
    }

    public static int [] WordSearch(int len, String s, String subs)  {
        ArrayList<Integer> rsl = new ArrayList<>();
        List<String> strings = xxx(len, s);
        for (String x : strings) {
            rsl.add(x.matches("(.*)"+ "(\s|^)" + subs+ "(\s|$)" + "(.*)") ? 1 : 0);
        }
        return rsl.stream().mapToInt(i -> i).toArray();
    }
}
