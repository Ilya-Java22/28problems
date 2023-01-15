import java.util.*;

public class Level1 {

    public static int[] s(int[] A, int N) {
        LinkedList<Integer> B = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int k = i + j;
                int[] ar = Arrays.copyOfRange(A, j, k + 1);
                Arrays.sort(ar);
                B.addLast(ar[ar.length - 1]);
            }
        }
        return B.stream().mapToInt(i -> i).toArray();
    }

    public static boolean TransformTransform(int[] A, int N) {
        int[] arr = s(A, N);
        int[] arr2 = s(arr, arr.length);
        int sum = Arrays.stream(A).sum();
        return sum % 2 == 0;
    }
}