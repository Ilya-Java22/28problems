import java.util.*;

public class Level1 {

    public static String BigMinus(String s1, String s2) {
        if (s2.length() > s1.length() || s1.length() == s2.length() && s2.charAt(0) > s1.charAt(0)) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        StringBuilder rsl = new StringBuilder();
        StringBuilder minus = new StringBuilder(s2);
        for (int i = 0; i < s1.length() - s2.length(); i++) {
            minus.insert(0, 0);
        }
        for (int i = s1.length() - 1, k = 0; i >= 0 ; i--) {
            int a = s1.charAt(i) - 48 - k;
            k = 0;
            int b = minus.charAt(i) - 48;
            if (a < b) {
                a += 10;
                k = 1;
            }
            rsl.insert(0, a - b);
        }
        for(int i = 0; i < rsl.length() - 1; i++) {
            if (rsl.charAt(i) != 48) {
                return rsl.substring(i);
            }
        }
        return rsl.substring(rsl.length() - 1);
    }
}
