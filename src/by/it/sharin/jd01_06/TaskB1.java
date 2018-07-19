package by.it.sharin.jd01_06;

public class TaskB1 {

    private final static String vowels = "ауеыояиюёАУЕЫОЯИЮЁ";

    private static boolean checkWord(String s){

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        return vowels.indexOf(first) < 0 && vowels.indexOf(last) >= 0;
    }

    public static void main(String[] args) {
        String[] words = Poem.text.split("[^а-яёА-ЯЁ]+");
        for (String word : words) {
            if (checkWord(word)){
                System.out.println(word);
            }
        }
    }

}
