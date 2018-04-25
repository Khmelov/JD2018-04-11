package by.it.shumilov.jd01_06;


import by.it.shumilov.jd01_06.Poem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        step1();


        /*Определить, сколько раз повторяется в тексте каждое слово, которое встречается в
нем, используя массивы. Вывести результаты на консоль в формате слово=повторы*/

    }

    private static void step1() {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);


        StringBuilder sb = new StringBuilder(Poem.text);
        while(matcher.find()){
            sb.setCharAt(matcher.start() + 3,'#');
            if(matcher.end()-matcher.start() >= 7)
                sb.setCharAt(matcher.start() + 6,'#');
        }
        System.out.println(sb.toString());
    }


}
