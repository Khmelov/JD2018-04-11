package by.it.rogov.jd01_06;


import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text=Poem.text.replace("...",",");
        Pattern pattern = Pattern.compile("[.!?]");
        String[] sentence = pattern.split(text);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].replaceAll("[\\p{Punct}\\p{Blank}\\n]+", " ").trim();

        }
        Comparator<String> stringLengthComparator = new StringLength();
        Arrays.sort(sentence, stringLengthComparator);
        for (String s : sentence) {

                System.out.print(s + "\n");

        }
    }


}
