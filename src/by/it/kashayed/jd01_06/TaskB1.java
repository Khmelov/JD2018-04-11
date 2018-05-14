package by.it.kashayed.jd01_06;

public class TaskB1 {

    private final static String gl ="уеыаоэяиюёУЕЫАОЭЯИЮЁ";

    private static boolean check(String word){
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);

        return gl.indexOf(first)<0&&gl.indexOf(last)>=0;
    }

    public static void main(String[] args) {
        String [] word = Poem.text.split("[^а-яёА-ЯЁ]+");
        for (String s : word) {
            if (check(s))
                System.out.println(s);
            }

    }
}
