public class Level1 {
    public static long calcFactorial(int N){
        long result = 1;
        for (int i = 2; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    public static int squirrel(int N){
        return String.valueOf(calcFactorial(N)).charAt(0) - 48;
    }
}
