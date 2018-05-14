package by.it.gavrilchik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern= Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = pattern.matcher(Poem.text);
        StringBuilder sb=new StringBuilder(Poem.text);

        while (m.find()){
            //System.out.println(m.group());
            sb.setCharAt(m.start()+3,'#');
            if (m.end()-m.start()>=7)
            sb.setCharAt(m.start()+6,'#');
        }
        System.out.println(sb.toString());


    }
}
