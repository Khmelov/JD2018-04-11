package by.it.tayanovskii.jd01_12;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    private static boolean checker(String text) {

        Map<String, String> bracketsMap = new HashMap<>();
        bracketsMap.put("[", "]");
        bracketsMap.put("(", ")");
        bracketsMap.put("{", "}");
        bracketsMap.put("<", ">");
        Pattern pattern = Pattern.compile("[\\[\\](){}<>]");
        Matcher m = pattern.matcher(text);

        ArrayDeque<String> openBrackets = new ArrayDeque<>();
        while (m.find())
            if (m.group().matches("[\\[({<]"))
                openBrackets.addFirst(m.group());
            else if (!(bracketsMap.get(openBrackets.pop())).equals(m.group()))
                return false;
        return openBrackets.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(checker(line));
    }
}
