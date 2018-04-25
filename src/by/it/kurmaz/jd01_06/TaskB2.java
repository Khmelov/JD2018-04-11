package by.it.kurmaz.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        int dots = poem.indexOf("...");
        poem.replace(dots, dots+3, ",");
        String[] sents =(poem.toString().split("[!?\\.]"));

        Pattern pattern = Pattern.compile("\\s?\\p{Punct}\\s?|\\s");

        int counter = 0;
        String[] formattedPoem = new String[sents.length];
        for (String sent: sents) {
            sent = sent.trim();
            Matcher matcher = pattern.matcher(sent);
            formattedPoem[counter] = matcher.replaceAll(" ");
            counter++;
        }

        counter = formattedPoem.length - 1;

        for (int i = 0; i < formattedPoem.length - 1; i++) {
            for (int j = 0; j < counter; j++) {
                if (formattedPoem[j].length() > formattedPoem[j + 1].length()) {
                    String buff = formattedPoem[j + 1];
                    formattedPoem[j + 1] = formattedPoem[j];
                    formattedPoem[j] = buff;
                }
            }
            counter--;
        }
        for (String sent: formattedPoem) {
            System.out.println(sent);
        }
    }
}
