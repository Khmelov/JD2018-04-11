package by.it.tayanovskii.jd01_06;

import java.util.Random;


public class TaskC2 {

    private static int[] randomIndexWord = new int[100000];
    private static int counter = 0;

    private static String slow(String text) {

        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String randomText="";
        counter=0;
        while (randomText.length() <= 100000) {

            randomIndexWord[counter] = new Random().nextInt(words.length);
            randomText = randomText.concat(words[randomIndexWord[counter]]).concat(" ");
            counter++;
        }
        return randomText;
    }

    private static String fast(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder randomText = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            randomText = randomText.append(words[randomIndexWord[i]]).append(" ");

        }
        return randomText.toString();


    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        String result_slow = slow(Poem.text);
        long end_slow = System.nanoTime();
        System.out.println("slow: " + (end_slow - start));
        //System.out.println(result_slow);
        start = System.nanoTime();
        String result_fast = fast(Poem.text);
        long end_fast = System.nanoTime();
        System.out.println("fast: " + (end_fast - start));
        //System.out.println(result_fast);
        if (result_slow.equals(result_fast))
            System.out.println("Совпадают");

    }
}
