package by.it.mokhart.jd01_06;

import java.util.Arrays;

public class TaskA2 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[а-яА-ЯЕ]+");
        for(String word:words)
        Arrays.sort(words);
        String word;
        for (int i = 0; i < words.length; i++)
        {
            if (!word.equals(words[i])) {
                System.out.println(word + "=" + count);
                word = words[i];
                count = 1;
            } else count++;
        }
        //String slovar = new String (words.length);

    }
}
