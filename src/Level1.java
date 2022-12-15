
public class Level1 {
    public static int[] UFO(int N, int[] data, boolean octal) {
       int[] rsl = new int[N];
       String s;
       int radix = octal ? 8 : 16;
       for (int i = 0; i < N; i++) {
           s = String.valueOf(data[i]);
           rsl[i] = Integer.parseInt(s, radix);
       }
       return rsl;
    }
}
