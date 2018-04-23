package by.it.lanevich.jd01_06;

import java.util.Arrays;

public class TaskA2 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[А-яЁё]{4,}");
        String[] slovar = new String[words.length];
        Arrays.sort(words[0]);
        //оптимизировать
        String word;
        int count=1;
        for (int i = 1; i < words.length; i++) {
            if (!word.get().equals(word[i]))
                System.out.println(word.get() +"=" + count);
            word.set(word[i]);
            count=1;
        } else count++;
    }
}
