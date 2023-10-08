package eight_problems;

import java.util.HashMap;

public class Cyberpunk {
    public static boolean EEC_help(int [] arr1, int [] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        HashMap<Integer, Integer> elementsAndCounts = new HashMap<>();
        for (int element : arr1) {
            elementsAndCounts.merge(element, 1, Integer::sum);
        }
        for (int element : arr2) {
            if (elementsAndCounts.computeIfPresent(element,(key, value) -> value - 1) == null) {
                return false;
            }
            elementsAndCounts.remove(element, 0);
        }
        return elementsAndCounts.isEmpty();
    }
}


