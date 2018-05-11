package by.it.kashayed.jd01_06;

import java.util.Arrays;

public class TaskA2 {
    public static void main(String[] args) {

        String [] words = Poem.text.split("[^а-яёА-яЁ]");
        Arrays.sort(words);
        String word = words[0];
        int count = 1;
        //String [] k = new String[words.length];
        //k[0]=words[0];
            for (int j = 1; j < words.length; j++) {
                if(!word.equals(words[j])){
                    System.out.println(word + "=" + count);
                    word = words[j];
                    count = 1;
            }
                else count++;

        }
        System.out.println(word + "=" + count);
        /*for (String s : words) {
                if(!s.isEmpty()){

            System.out.println(s+count);
                }

        }*/
    }

}
