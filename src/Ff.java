import java.util.*;

public class Ff {
    public static String Ff(int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            if (Math.sqrt(i + 1) == (int)Math.sqrt(i + 1)) {
                arr[i] = 1;
            }
        }
        return Arrays.toString(arr);
    }
}