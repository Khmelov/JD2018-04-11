package by.it.tayanovskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] text = Poem.text.split("\\n");
        int max_length = 0;
        for (String string : text) {
            if (string.length() > max_length)
                max_length = string.length();
        }
//        System.out.println(max_length);

        Pattern pattern = Pattern.compile("\\s+");
        for (String stringText : text) {

            StringBuilder formatString = new StringBuilder(stringText);
            Matcher matcher = pattern.matcher(formatString);
            int pos_matcher = 0;
            String replace = "  ";
            for (int i = max_length; i > stringText.length(); i--) {
                if (matcher.find(pos_matcher)) {
                    formatString.replace(matcher.start(), matcher.end(), replace);
                    pos_matcher = matcher.end() + 1;
                }
                else {
                    replace+= " ";
                    pos_matcher = 0;
                    i++;

                }
            }

            System.out.println(formatString);
        }

    }
}
