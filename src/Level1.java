import java.util.*;

public class Level1 {

    public static String BigMinus(String s1, String s2) {
        Long a = Long.parseLong(s1);
        Long b = Long.parseLong(s2);
        return Long.toString(Math.abs(a - b));
    }
}
