package by.it.dkruchek.jd01_06;

import java.util.Random;

/**
 * Created by Dmitriy.Kruchek on 4/24/2018.
 */
public class TaskC2 {
    private final static int seed = 99;
    private final static int maxChars = 100000;

    private static String slow(String text){
        String[] words = text.split("[^А-Яа-яёЁ]+");
        int maxRandNum = words.length;
        Random random = new Random(seed);
        String result = "";
        while (result.length() < maxChars)
            result += words[random.nextInt(maxRandNum)] + " ";

        return result;
    }

    private static String fast(String text){
        String[] words = text.split("[^А-Яа-яёЁ]+");
        int maxRandNum = words.length;
        Random random = new Random(seed);
        StringBuilder space = new StringBuilder(" ");
        StringBuilder sb[] = new StringBuilder[words.length];
        for (int i = 0; i < words.length; i++)
            sb[i] = new StringBuilder(words[i]);
        StringBuilder result = new StringBuilder();
        result.ensureCapacity(100000);
        while (result.length() < maxChars)
            result.append(sb[random.nextInt(maxRandNum)]).append(space);

        return result.toString();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        slow(Poem.text);
        long end = System.nanoTime();
        long timeSlow = end - start;

        start = System.nanoTime();
        slow(Poem.text);
        end = System.nanoTime();
        long timeFast = end - start;

        System.out.printf("Execution time of slow method is: %d\n", timeSlow);
        System.out.printf("Execution time of fast method is: %d\n", timeFast);


    }
}
