import java.util.*;

public class Level1 {
    public static String[] ShopOLAP(int N, String[] items)  {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : items) {
            String[] ss = s.split(" ");
            hm.put(ss[0], hm.getOrDefault(ss[0], 0) + Integer.parseInt(ss[1]));
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(hm.entrySet());
        Comparator<Map.Entry<String, Integer>> comp = (o1, o2) -> {
            int rsl =  o1.getValue().compareTo(o2.getValue());
            return rsl == 0 ? o1.getKey().compareTo(o2.getKey()) : rsl;
        };
        entries.sort(comp);
        String[] result = new String[entries.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            result[i++] = entry.getKey() + " " + entry.getValue();
        }
        return result;
    }
}
