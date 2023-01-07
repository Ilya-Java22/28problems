import java.util.*;

public class Level1 {

    public static boolean SherlockValidString(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        List<Integer> rsl = new ArrayList<>(hm.values());
        if (Collections.frequency(rsl, rsl.get(0)) == rsl.size()) {
            return true;
        }
        Collections.sort(rsl);
        if (rsl.get(0) == 1 && (Collections.frequency(rsl, rsl.get(rsl.size() - 1)) == rsl.size() - 1)) {
            return true;
        }
        if (rsl.get(rsl.size() - 1) == rsl.get(0) + 1 && (Collections.frequency(rsl, rsl.get(0)) == rsl.size() - 1)) {
            return true;
        }
        return false;
    }
}