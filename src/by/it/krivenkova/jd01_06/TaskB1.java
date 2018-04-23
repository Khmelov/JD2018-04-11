package by.it.krivenkova.jd01_06;

public class TaskB1 {

    private final static String gl="уеэыаояиюёЁУЕЫАОЭЯИЮ";

    private static boolean check(String word){
        char first = word.charAt(0);
        char list = word.charAt(word.length() - 1);
        return (gl.indexOf(first) < 0) && (gl.indexOf(list)>= 0);
    }

    public static void main(String[] args) {
        String[] words = Poem.text.split("[а-яА-ЯёЁ]+");
        for (String word:words){
            if (check(word))
            System.out.println(word);
        }
    }
}
