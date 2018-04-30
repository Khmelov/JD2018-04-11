package by.it.tayanovskii.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String [] text = Poem.text.replace("...", " ").split("[!?.]+");
        Pattern p = Pattern.compile("[\\p{Punct}\\p{Blank}\\n]+");
        String [] formatString = new String[text.length];
        for (int i = 0; i < text.length; i++) {
            Matcher m = p.matcher(text[i]);
            formatString[i]=m.replaceAll(" ").trim();
            System.out.println(formatString[i]);

        }
        System.out.println();
        for (int i = 0; i < formatString.length; i++) {
            for (int j = i+1; j < formatString.length; j++) {
                if (formatString[i].length()>formatString[j].length())
                {
                    String stringTemp=formatString[i];
                    formatString[i]=formatString[j];
                    formatString[j]=stringTemp;
                }
            }

            System.out.println(formatString[i]);
        }



    }
}
