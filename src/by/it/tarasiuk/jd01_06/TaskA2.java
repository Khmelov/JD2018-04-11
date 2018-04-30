package by.it.tarasiuk.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words={};
    private static int[] counter={};

    private static int position(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word=matcher.group();
            int p = position(word);
            if (p>=0) {
                counter[p]++;
            }
            else {
                int last=words.length;
                words=Arrays.copyOf(words, last+1);
                words[last]=word;
                counter=Arrays.copyOf(counter,last+1);
                counter[last]=1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+counter[i]);
        }
    }
}