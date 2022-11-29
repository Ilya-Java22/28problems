public class Level1 {
    public static int odometer(int [] oksana){
        int rsl = oksana[0] * oksana[1];
        for (int i = 2; i < oksana.length; i = i + 2) {
            int time = oksana[i + 1] - oksana [i - 1];
            rsl += oksana[i] * time;
        }
        return rsl;
    }
}
