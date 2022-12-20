public class Level1 {
    public static boolean LineAnalysis(String line) {
        if (line.matches("\\*+")) {
            return true;
        }
        String s = line.substring(0,line.indexOf('*', 1));
        int lLen = line.length();
        int sLen = s.length();
        if (lLen % sLen != 1) {
            return false;
        }
        for (int i = sLen; i < lLen - sLen; i += sLen) {
            String ss = line.substring(i, i + sLen);
            if (!ss.equals(s)) {
                return false;
            }
        }
        return true;
    }
}
