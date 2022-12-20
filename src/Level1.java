
public class Level1 {
    public static char[][] fillArray(int h, int w, String s) {
        String[] a = s.split(" ");
        char[][] rsl = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                rsl[i][j] = a[i].charAt(j);
            }
        }
        return rsl;
    }

    public static boolean equalArray(int x, int y, char[][] a, char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (a[i + x][j + y] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        char[][] a = fillArray(H1, W1, S1);
        char[][] b = fillArray(H2, W2, S2);
        for (int i = 0; i <= H1 - H2; i++) {
            for (int j = 0; j <= W1 - W2; j++) {
                if (a[i][j] == b[0][0] && equalArray(i, j, a, b)) {
                    return true;
                }
            }
        }
       return false;
    }
}
