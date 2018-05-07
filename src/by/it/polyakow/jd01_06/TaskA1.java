package by.it.polyakow.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()) {
            //System.out.println(m.group());
            sb.setCharAt(matcher.start() + 3, '#');
            if (matcher.end() - matcher.start() >= 7)
                sb.setCharAt(matcher.start() + 6, '#');
        }
        System.out.println(sb.toString());

    }
    
}
