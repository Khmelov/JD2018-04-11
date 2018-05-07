package by.it.kurmaz.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] lines = Poem.text.split("\\n");

        /*for (String line: lines) {
            System.out.println(line);
        }*/

        int maxLength = lines[0].length();
        for (String line: lines) {
            if (line.length() > maxLength)
                maxLength = line.length();
        }
        Pattern pattern = Pattern.compile("\\s+");
        for (String line: lines) {
            StringBuilder formatLine = new StringBuilder(line);
            Matcher matcher = pattern.matcher(formatLine);
            int spaces = maxLength - line.length();
            int index = 0;
            int steps = 0;
            String replacement = "  ";
            for (int i = spaces; i > 0; i--) {
                if (matcher.find(index)) {
                    formatLine.replace(matcher.start(), matcher.end(), replacement);
                    index = matcher.end() + 1;
                }
                else {
                    index = 0;
                    i++;
                    replacement = replacement+" ";
                }
            }
            System.out.println(formatLine.toString());
        }
    }
}
