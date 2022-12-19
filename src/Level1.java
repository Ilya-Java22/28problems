
public class Level1 {
    public static int Unmanned (int L, int N, int[][] track) {
       int delta = 0;
       for (int i = 0; i < N; i++) {
           int x = (delta + track[i][0]) % (track[i][1] + track[i][2]);
           delta += x < track[i][1] ? track[i][1] - x : 0;
       }
       return L + delta;
    }
}
