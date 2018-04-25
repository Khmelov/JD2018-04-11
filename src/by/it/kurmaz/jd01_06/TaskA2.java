package by.it.kurmaz.jd01_06;

import java.util.Arrays;

public class TaskA2 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[^а-яА-яёЁ]+");
        Arrays.sort(words);
        int counter = 1;
        for (int i = 0; i < words.length - 1; i++) {
            if ((words[i] != null) && (words[i].equals(words[i+1])))
            counter++;
            else if ((words[i] != null) && (!words[i].equals(words[i+1]))) {
                System.out.println(words[i]+"="+counter);
                counter = 1;
            }
            if ((i == words.length -2) && (!words[i].equals(words[i+1])))
            System.out.println(words[i+1]+"="+1);
        }
    }
}
