package by.it.krivenkova.jd01_06;

import java.util.Arrays;

public class TaskA2 {
    public static void main(String[] args) {

        String[] words = Poem.text.split("[^а-яА-ЯёЁ]+");
        Arrays.sort(words);
        String word = words[0];
        int count = 1;
        for (int i = 1; i < words.length; i++) {
            if (!word.equals(words[i])){
                System.out.println(word+"="+count);
                word = words[i];
                count = 1;
            }
            else {
                count++;
            }
        }
        System.out.println(word + "=" + count);
        //String[] slovar = new String[words.length];
        //int[] count = new int[words.length];
    }
}
