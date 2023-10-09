package eight_problems;

import java.util.HashMap;

public class Cyberpunk3 {
    public static int massdriver(int[] activate) {
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        int firstDuplicateIndex = -1;
        for (int i = 0; i < activate.length; i++) {
            if (duplicates.containsKey(activate[i]) &&
                    (firstDuplicateIndex == -1 || firstDuplicateIndex > duplicates.get(activate[i]))) {
                firstDuplicateIndex = duplicates.get(activate[i]);
                continue;
            }
            duplicates.put(activate[i], i);
        }
        return firstDuplicateIndex;
    }
}
