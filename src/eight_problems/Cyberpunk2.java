package eight_problems;

import java.util.BitSet;

public class Cyberpunk2 {
    public static int artificial_muscle_fibers(int[] arr) {
        BitSet elementsValues = new BitSet(32000);
        BitSet duplicates = new BitSet();
        for (int number : arr) {
            if (!elementsValues.get(number - 1)) {
                elementsValues.set(number - 1);
                continue;
            }
            duplicates.set(number - 1);
        }

        return duplicates.cardinality();
    }
}
