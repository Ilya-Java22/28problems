import java.util.*;

public class Level1 {

    public static int Greater(String c, List<String> list) {
        for (String ch : list) {
            if (ch.compareTo(c) > 0) {
                return list.indexOf(ch);
            }
        }
        return -1;
    }

    public static String BiggerGreater(String input) {
        for (int i = input.length() - 1; i > 0; i--) {
            if (input.charAt(i) > input.charAt(i - 1)) {
                String[] s1 = input.split("");
                List<String> chlist = Arrays.asList(s1);
                chlist.subList(i, chlist.size()).sort(Comparator.naturalOrder());
                int x = Greater(String.valueOf(input.charAt(i - 1)), chlist.subList(i, chlist.size()));
                String temp = chlist.get(i - 1);
                chlist.set(i - 1, chlist.get(i + x));
                chlist.set(i + x, temp);
                return String.join("", chlist);
            }
        }
        return "";
    }
}

