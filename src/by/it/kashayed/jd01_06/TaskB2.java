package by.it.kashayed.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ\\n] ");
        Matcher matcher = pattern.matcher(Poem.text);
        String [] mas = new String [Poem.text.length()];
            while(matcher.find()){
                stringBuilder.setCharAt(matcher.start(), ' ');
            }

        System.out.println(stringBuilder);
    }

}
