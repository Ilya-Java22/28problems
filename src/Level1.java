import java.util.*;

public class Level1 {
    static Stack<String> undo = new Stack<>();
    static Stack<String> redo = new Stack<>();
    static boolean action = false;

    public static String BastShoe(String command) {
        String[] s1 = command.split(" ", 2);
        switch (Integer.parseInt(s1[0])) {
            case 1 :
                if (action) {
                    redo.clear();
                    undo.subList(0, undo.size() - 1).clear();
                    action = false;
                }
                String s2 = undo.isEmpty() ? "" : undo.peek();
                undo.push(String.join("", s2, s1[1]));
                return undo.peek();
            case 2 :
                if (action) {
                    redo.clear();
                    undo.subList(0, undo.size() - 1).clear();
                    action = false;
                }
                String s3 = undo.isEmpty() ? "" : undo.peek();
                int ch = Integer.parseInt(s1[1]);
                ch = Math.min(ch, s3.length());
                undo.push(s3.substring(0, s3.length() - ch));
                return undo.peek();
            case 3 :
                String s4 = undo.isEmpty() ? "" : undo.peek();
                int n = Integer.parseInt(s1[1]);
                if (n >= s4.length()) {
                    return "";
                }
                return String.valueOf(s4.charAt(n));
            case 4 :
                action = true;
                if (undo.size() != 1) {
                    redo.push(undo.pop());
                }
                return undo.peek();
            case 5 :
                action = false;
                if (!redo.isEmpty()) {
                    undo.push(redo.pop());
                }
                return undo.peek();
            default :
                return undo.isEmpty() ? "" : undo.peek();
        }
    }
}
