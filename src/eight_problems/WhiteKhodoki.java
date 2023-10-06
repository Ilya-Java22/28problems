package eight_problems;

import java.util.Arrays;

import static java.lang.Character.isDigit;

public class WhiteKhodoki {
    public static boolean white_walkers(String village) {
        int start = -1;
        int end = -1; // в рекомендациях это лишнее, проверяем на лету
        int countEqualSymbol = 0;
        int walkers = 0; // в рекомендациях - хватит, оказывается, и просто boolean, ведь мы возвр false раньше соотв. проверки, не упустим момент)
        for (int i = 0; i < village.length(); i++) {
            if (isDigit(village.charAt(i)) && village.charAt(i) != 48 ) { //в рекомендациях лишний блок
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

    public static boolean white_walkers_answer(String village) {
        int digit = 48;
        int countEqualSymbol = 0;
        boolean walkers = false;
        for (int i = 0; i < village.length(); i++) {
            Character currentChar = village.charAt(i);
            if (isDigit(currentChar) && village.charAt(i) + digit == 106 && countEqualSymbol != 3) {
                return false;
            }
            if (isDigit(currentChar) && village.charAt(i) + digit == 106 && countEqualSymbol == 3) {
                walkers = true;
                digit = currentChar;
                countEqualSymbol = 0;
            }
            if (isDigit(currentChar) && village.charAt(i) + digit != 106) { // можно объединить с предыдущим if как в моем решении
                digit = currentChar;
                countEqualSymbol = 0;
            }
            if (currentChar == 61) {
                countEqualSymbol++;

            }
        }
        return walkers;
    }



}
