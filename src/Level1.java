import java.util.*;

public class Level1 {

    public static int[] SynchronizingTables(int N, int[] ids, int[] salary) {
        int[] rsl = new int[N];
        LinkedHashMap<Integer, Integer> hash = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            hash.put(ids[i], 0);
        }
        Arrays.sort(ids);
        Arrays.sort(salary);
        LinkedHashMap<Integer, Integer> hash2 = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            hash2.put(ids[i], salary[i]);
        }
        hash.putAll(hash2);
        int i = 0;
        for(int j : hash.values()) {
            rsl[i++] = j;
        }
        return rsl;
    }
}

