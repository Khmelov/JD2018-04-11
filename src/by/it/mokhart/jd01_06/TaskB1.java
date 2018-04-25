package by.it.mokhart.jd01_06;

public class TaskB1 {

    private final static String str = "аоуеиэуыяюёУЕЭОАЫЯИЮЁ";

    private static boolean check(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return str.indexOf(first) < 0 && str.indexOf(last) >= 0;
    }

    public static void main(String[] args) {
        String[] words = Poem.text.split("[^а-яёА-ЯЁ]+");
        for (String word : words) {
            if (check(word))
                System.out.println(word);
        }
    }
}