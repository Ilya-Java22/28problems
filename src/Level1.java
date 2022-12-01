public class Level1 {

    public static int sum2D(int[][] a) {
        int sum = 0;
        for(int[] n : a) {
            for(int m : n) {
                sum += m;
            }
        }
        return sum;
    }
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
        int days = 1;
        int[][] nm = new int[N][M];
        for (int i = 0; i < battalion.length; i = i + 2) {
            nm[battalion[i] - 1][battalion[i + 1] - 1] = 1;
        }
        while (sum2D(nm) != N * M) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (nm[i][j] == 1) {
                        try {
                            nm[i][j + 1] = 1;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            nm[i][j - 1] = 1;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            nm[i + 1][j] = 1;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            nm[i - 1][j] = 1;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }
            }
            days++;
        }
        return days;
        }
}
