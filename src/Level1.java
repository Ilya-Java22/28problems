import java.util.*;

public class Level1 {
    public static int[][] stringToInt(int H, int W, String[] tree) {
        int[][] rsl = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                rsl[i][j] = tree[i].charAt(j) == '+' ? 1 : 0;
            }
        }
        return rsl;
    }

    public static String[] intToString(int H, int W, int[][] orig) {
        String[] rsl = new String[H];
        for (int i = 0; i < H; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < W; j++) {
                sb.append(orig[i][j] == 0 ? '.' : '+');
            }
            rsl[i] = sb.toString();
        }
        return rsl;
    }

    public static void destroy(int H, int W, int[][] orig) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (orig[i][j] >= 3) {
                    orig[i][j] = 0;
                    try {
                        orig[i][j + 1] = orig[i][j + 1] >= 3 ? 3 : 0;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        orig[i][j - 1] = orig[i][j - 1] >= 3 ? 3 : 0;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        orig[i + 1][j] = orig[i + 1][j] >= 3 ? 3 : 0;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        orig[i - 1][j] = orig[i - 1][j] >= 3 ? 3 : 0;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
    }

    public static String[] TreeOfLife(int H, int W, int N, String[] tree) {
        int[][] intTree = stringToInt(H, W, tree);
        int age = 0;
        while (age < N) {
            age++;
            for (int[] arr : intTree) {
                Arrays.setAll(arr, e -> ++arr[e]);
            }
            if (age > 0 && age % 2 == 0) {
                destroy(H, W, intTree);
            }
        }
        return intToString(H, W, intTree);
    }
}