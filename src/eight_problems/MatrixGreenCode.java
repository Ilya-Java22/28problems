package eight_problems;

import java.util.HashMap;

public class MatrixGreenCode {
    public static String digital_rain(String col) {
        int[] testArray = new int[col.length()];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = col.charAt(i) - 48;
        }
        HashMap<Integer, Integer> sumsAndIndexes = new HashMap<>();
        int elementsSum = 0;
        int maxLength = 0;
        int finishIndex = -1;
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (testArray[i] == 0) ? -1 : 1;
        }
        for (int i = 0; i < testArray.length; i++) {
            elementsSum += testArray[i];
            if (elementsSum == 0) {
                maxLength = i + 1;
                finishIndex = i;
            }
            if (sumsAndIndexes.containsKey(elementsSum) && maxLength <= i - sumsAndIndexes.get(elementsSum)) {
                maxLength = i - sumsAndIndexes.get(elementsSum);
                finishIndex = i;
            }
            if (!sumsAndIndexes.containsKey(elementsSum)) {
                sumsAndIndexes.put(elementsSum, i);
            }
        }
        return col.substring(finishIndex - maxLength + 1, finishIndex + 1);
    }
}
