public class Level1 {
    public static boolean MisterRobot(int N, int[] data) {
        boolean x = true;
        int n = 0;
        while (x) {
            x = false;
            n = 0;
            for (int i = 1, temp = 0; i < N - 1; i++) {
                if (data[i] >= data[i - 1] && data[i + 1] < data[i - 1]
                        || data[i + 1] == data[i - 1] && data[i] > data[i - 1]) {
                    temp = data[i + 1];
                    data[i + 1] = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = temp;
                    x = true;
                    continue;
                }
                if (data[i + 1] <= data[i - 1] && data[i + 1] > data[i]
                        || data[i + 1] == data[i] && data[i - 1] > data[i]) {
                    temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    x = true;
                    continue;
                }
                if (data[i + 1] >= data[i] && data[i - 1] <= data[i]) {
                    n++;
                }
            }
        }
        return n == N - 2;
    }
}
