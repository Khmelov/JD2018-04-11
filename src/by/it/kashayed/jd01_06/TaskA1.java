package by.it.kashayed.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = pattern.matcher(Poem.text);
        StringBuilder s1 = new StringBuilder(Poem.text);
        while (m.find()){
            s1.setCharAt(m.start()+3,'#');
            if (m.end()-m.start()>=7){
                s1.setCharAt(m.start()+6,'#');
            }
            System.out.println(s1);
        }
    }
}
