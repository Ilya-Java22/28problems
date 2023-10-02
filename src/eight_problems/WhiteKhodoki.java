package eight_problems;

public class WhiteKhodoki {
    public static boolean white_walkers(String village) {
        int start = -1;
        int end = -1;
        int countEqualSymbol = 0;
        int walkers = 0;
        for (int i = 0; i < village.length(); i++) {
            if (Character.isDigit(village.charAt(i)) && village.charAt(i) != 48 ) {
                end = start == -1 ? -1 :i;
                start = start == -1 ? i : start;
            }
            if (start != -1 && end == -1 && village.charAt(i) == 61) {
                countEqualSymbol++;
                continue;
            }
            if (start != -1 && end != -1 && village.charAt(start) + village.charAt(end) == 106 && countEqualSymbol != 3) {
                return false;
            }
            if (start != -1 && end != -1 &&
                    (village.charAt(start) + village.charAt(end) != 106 || (village.charAt(start) + village.charAt(end) == 106 && countEqualSymbol == 3))) {
                walkers = village.charAt(start) + village.charAt(end) != 106 ? walkers : walkers + 1;
                start = end;
                end = -1;
                countEqualSymbol = 0;
            }
        }
        return walkers > 0;

    }
}
