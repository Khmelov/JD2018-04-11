package by.it.kurmaz.jd01_06;

public class TaskB1 {

    private static final String gl = "уеыаоэяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {
        String[] words = Poem.text.split("[^а-яА-яёЁ]+");
        for (String word: words) {
            if (check(word))
                System.out.println(word);

        }

    }
    private static boolean check(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return (gl.indexOf(first) <0 && gl.indexOf(last) >= 0);
    }
}
