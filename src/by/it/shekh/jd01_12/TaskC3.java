package by.it.shekh.jd01_12;

import java.util.*;

public class TaskC3 {
    private static Set<Character> open = new HashSet<>(Arrays.asList('{', '[', '('));
    private static Set<Character> close = new HashSet<>(Arrays.asList('}', ']', ')'));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(retResult(str));

    }

    private static boolean retResult(String str) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int symbolGroup = getSymbolGroup(ch);
            switch (symbolGroup) {
                case 0:
                    deque.addLast(ch);
                    break;
                case 1:
                    if (deque.isEmpty())
                        return false;
                    if (!equal(deque.pollLast(), ch))
                        return false;
                    break;
                case 2:
                    break;
            }

        }
        return deque.isEmpty();
    }

    private static int getSymbolGroup(char ch) {
        if (open.contains(ch))
            return 0;
        if (close.contains(ch))
            return 1;
        return 2;
    }

    private static boolean equal(char first, char last) {
        switch (first) {
            case '{':
                return last == '}';
            case '(':
                return last == ')';
            case '[':
                return last == ']';
            default:
                return false;
        }

    }
}
