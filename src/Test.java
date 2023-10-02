import java.util.*;

public class Test {
    public static String Keymaker(int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (Math.sqrt(i + 1) == (int)Math.sqrt(i + 1)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Keymaker(1));
        System.out.println(Keymaker(2));
        System.out.println(Keymaker(3));
        System.out.println(Keymaker(4));
        System.out.println(Keymaker(5));
        System.out.println(Keymaker(6));
        System.out.println(Keymaker(7));
        System.out.println(Keymaker(8));
        System.out.println(Keymaker(9));
        System.out.println(Keymaker(10));
        System.out.println(Keymaker(11));
        System.out.println(Keymaker(12));
        System.out.println(Keymaker(13));
        System.out.println(Keymaker(14));
        System.out.println(Keymaker(15));
        System.out.println(Keymaker(16));
    }
}