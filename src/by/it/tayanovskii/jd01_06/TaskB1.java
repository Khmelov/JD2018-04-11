package by.it.tayanovskii.jd01_06;

public class TaskB1 {

    private final static String gl="уеэоаыяиюёУЕЭОАЫЯИЮЁ";
    private static boolean check(String word)
    {
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        return gl.indexOf(first)<0 && gl.indexOf(last)>=0;
    }

    public static void main(String[] args) {

        String[] words = Poem.text.split("[^а-яёА-ЯЁ]+");
        for (String word : words) {
            if(check(word))
                System.out.println(word);
        }

    }
}
