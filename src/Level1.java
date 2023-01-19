import java.util.*;

public class Level1 {

    public static boolean checkSort(int[] F) {
        int[] copyF = F.clone();
        Arrays.sort(F);
        return Arrays.equals(copyF, F);
    }

    public static boolean Football(int[] F, int N) {
        int[] copyF = F.clone();
        int a = -1;
        int b = 0;
        for (int i = 0; i < N - 1; i++) {
            if (a != -1 && copyF[i] < copyF[i + 1]) {
                break;
            }
            if (copyF[i] > copyF[i + 1]) {
                a = a < 0 ? i : a;
                b = i + 1;
            }
        }
        Arrays.sort(copyF, a, b + 1);
        if (b - a > 1) {
            return checkSort(copyF);
        }
        if (b - a == 1 && checkSort(copyF)) {
            return true;
        }
        int submax = copyF[b];
        int submin = copyF[a];
        for (int j = b + 1; j < N; j++) {
            copyF = F.clone();
            if (copyF[j] > submax) {
                return false;
            }
            if (copyF[j] < submin) {
                int temp = copyF[a];
                copyF[a] = copyF[j];
                copyF[j] = temp;
                if (checkSort(copyF)) {
                    return true;
                }
            }
        }
        return false;
    }
}