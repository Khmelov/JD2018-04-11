package by.it.kurmaz.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        StringBuilder bufPoem = new StringBuilder(Poem.text);
        while (matcher.find()) {
            bufPoem.setCharAt(matcher.start()+3, '#');
            if (matcher.end() - matcher.start() >=7)
                bufPoem.setCharAt(matcher.start()+6, '#');
        }
        System.out.println(bufPoem.toString());
    }
}
