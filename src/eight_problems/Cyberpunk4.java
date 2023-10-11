package eight_problems;

public class Cyberpunk4 {
    public static int[] TRC_sort(int[] trc) {
        int Lo = -1;
        int Mid = 0;
        int Hi = trc.length - 1;
        while (Mid <= Hi) {
            if (trc[Mid] == 0) {
                swap(trc, Mid, Lo + 1);
                Lo++;
                Mid++;
            } else
            if (trc[Mid] == 1) {
                Mid++;
            } else
            if (trc[Mid] == 2) {
                swap(trc, Mid, Hi);
                Hi--;
            }
        }
        return trc;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
