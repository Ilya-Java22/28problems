import java.util.*;
import static java.lang.Character.isDigit;

public class Level1 {

    public static boolean white_walkers(String village) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < village.length(); i++) {
            if (isDigit(village.charAt(i))) {
                list.add(i);
            }
        }
        if (list.size() < 2) {
            return false;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (village.charAt(list.get(i)) + village.charAt(list.get(i + 1)) == 106
                    && !village.substring(list.get(i) + 1, list.get(i + 1)).matches("(\\D*)"
                    + "=" + "(\\D*)" + "=" + "(\\D*)" + "=" + "(\\D*)")) {
                return false;
            }
        }
        return true;
    }
}