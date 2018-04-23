package by.it.tarasiuk.jd01_06;

import java.util.Arrays;

public class TaskA2 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[^а-яёА-ЯЁ]+");
        Arrays.sort(words);
        String word = words[0];
        int count=1;//do-while
        for (int i = 1; i <words.length ; i++) {
            if (!word.equals(words[i])){
                System.out.println(word +"="+count);
                word=words[i];
                count=1;
            }else count++;

        }
//        String[] slovar = new String[words.length];
//        int[] count = new int[words.length];


    }
}
