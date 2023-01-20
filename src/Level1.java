public class Level1 {
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
}