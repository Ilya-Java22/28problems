import java.util.*;

public class Level1 {
    public static int MaximumDiscount(int N, int [] price) {
        int sum = 0;
        Arrays.sort(price);
        for (int i = N - 3; i >= 0; i -= 3) {
            sum += price[i];
        }
        return sum;
    }
}
