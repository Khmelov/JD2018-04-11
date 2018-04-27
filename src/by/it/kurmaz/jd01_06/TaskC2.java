package by.it.kurmaz.jd01_06;

import java.util.Random;

public class TaskC2 {
    private static int[] array = new int[100000];
    private static int counter = 0;
    public static void main(String[] args) {
        long start = System.nanoTime();
        String slowLine = slow(Poem.text);
        long end = System.nanoTime();
        String fastLine = fast(Poem.text);
        long end2 = System.nanoTime();

        //Проверка идентичности возвращаемых строк.
        if (slowLine.equals(fastLine))
            System.out.println("Match");
        else
            System.out.println("No match");

        System.out.println("Slow time = " + (end - start)/1000);
        System.out.println("Fast time = " + (end2 - end)/1000);
        System.out.println("Fast and slow time has a difference in " +(end - start)/(end2 - end)+ " times");
    }

    private static String fast(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String startLine = "";
        StringBuilder line = new StringBuilder(startLine);
        for (int i = 0; i < counter; i++) {
            line.append(words[array[i]]).append(" ");
        }
        return line.toString();
    }

    private static String slow(String text) {
        long lineLength = 0;
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String line = "";
        int index;
        counter = 0;
        while (lineLength < 100000) {
            index = new Random().nextInt(words.length);
            array[counter] = index;
            counter++;
            line = line.concat(words[index]).concat(" ");
            lineLength = line.length();
        }
        return line;
    }
}
