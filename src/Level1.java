public class Level1 {

    public static StringBuilder[] stringToStringBuilder(String[] Matrix, int M, int N) {
        StringBuilder[] sb = new StringBuilder[Math.min(N, M) / 2];
        for (int k = 0; k < sb.length; k++) {
            sb[k] = new StringBuilder();
            for (int i = k; i < N - k; i++) {
                sb[k].append(Matrix[k].charAt(i));
            }
            for (int i = 1 + k; i < M - 1 - k; i++) {
                sb[k].append(Matrix[i].charAt(N - 1 - k));
            }
            for (int i = k; i < N - k; i++) {
                sb[k].append(Matrix[M - 1 - k].charAt(N - 1 - i));
            }
            for (int i = 1 + k; i < M - 1 - k; i++) {
                sb[k].append(Matrix[M - 1 - i].charAt(k));
            }
        }
        return sb;
    }

    public static char[][] stringBuilderToCharArray(StringBuilder[] sb, int M, int N) {
        char[][] ch = new char[M][N];
        for (int k = 0; k < sb.length; k++) {
            int j = 0;
            for (int i = k; i < N - k; i++) {
                ch[k][i] = sb[k].charAt(j++);
            }
            for (int i = 1 + k; i < M - 1 - k; i++) {
                ch[i][N - 1 - k] = sb[k].charAt(j++);
            }
            for (int i = k; i < N - k; i++) {
                ch[M - 1 - k][N - 1 - i] = sb[k].charAt(j++);
            }
            for (int i = 1 + k; i < M - 1 - k; i++) {
                ch[M - 1 - k - i][k] = sb[k].charAt(j++);
            }
        }
        return ch;
    }

    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {
        StringBuilder[] sb = stringToStringBuilder(Matrix,  M,  N);
        for (StringBuilder s : sb) {
            s.insert(0, s.substring(s.length() - T));
            s.delete(s.length() - T, s.length());
        }
        char[][] ch = stringBuilderToCharArray(sb, M, N);
        for (int i = 0; i < M; i++) {
            Matrix[i] = String.valueOf(ch[i]);
        }
    }
}