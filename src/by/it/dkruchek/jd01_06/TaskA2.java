package by.it.dkruchek.jd01_06;

import java.util.Arrays;

/**
 * Created by Dmitriy.Kruchek on 4/23/2018.
 */
public class TaskA2 {

    public static void main(String[] args) {
        String[] words = Poem.text.split("[^а-яёА-ЯЁ]+");
        Arrays.sort(words);
        String word = words[0];
        int counter = 1;
        for (int i = 1; i < words.length; i++) {
            if (!word.equals(words[i])){
                System.out.println(word + "=" + counter);
                word = words[i];
               counter = 1;
            } else {
                counter++;
            }
        }
        System.out.println(word + "=" + counter);
    }
}
