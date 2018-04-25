package by.it.lanevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern p=Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher m=p.matcher(Poem.text);
        while (m.find()){
            sb.setCharAt(m.start()+3, '#');
            if (m.group().length()>=7)
                sb.setCharAt(m.start()+6,'#');

        }
        System.out.println(sb);
    }
}
//    В каждом слове текста 4-ю и 7-ю буквы заменить символом #. Для слов короче 4
////        символов корректировку не выполнять. Для слов короче 7 символов заменять только 4-ю букву.