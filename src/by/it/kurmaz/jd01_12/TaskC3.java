package by.it.kurmaz.jd01_12;

import java.util.*;

public class TaskC3 {

    private static char[] openBrackets = new char[] {(char)40, (char)91, (char)123};
    private static char[] closeBrackets = new char[] {(char)41, (char)93, (char)125};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line to proceed");
        String line = scanner.nextLine();
        line = line.trim().replace(" ", "");
        CharSequence[] lines = line.split("");
        ArrayList<Character> list = new ArrayList<>();
        for (CharSequence c: lines) {
            list.add(c.charAt(0));
        }
        ArrayList<Character> open = new ArrayList<>();
        ArrayList<Character> close = new ArrayList<>();
        for (Character c: openBrackets) {
            open.add(c);
        }
        for (Character c: closeBrackets) {
            close.add(c);
        }

        ArrayList<Character> full= new ArrayList<>(open);
        full.addAll(close);
        list.retainAll(full);
        List<Character> checker = new LinkedList<>();

        for (char c: list) {
            if (open.contains(c)) {
                int index = open.indexOf(c);
                checker.add(open.get(index));
            }
            else {
                Iterator iterator = ((LinkedList<Character>) checker).descendingIterator();
                Character toCheck = (Character) iterator.next();
                if (open.indexOf(toCheck) == close.indexOf(c))
                    iterator.remove();
            }
        }
        if (checker.size() != 0)
            System.out.println("false");
        else
            System.out.println("true");
    }
}
