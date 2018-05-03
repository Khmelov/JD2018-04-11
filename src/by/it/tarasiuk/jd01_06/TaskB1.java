package by.it.tarasiuk.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String[] words=Poem.text.split("[^а-яёА-ЯЁ]+");
        for (String word : words) {
            if (check(word)) System.out.println(word);
        }
    }

    private static boolean check (String word) {
        String vowels="аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        char firstLetter=word.charAt(0);
        char lastLetter=word.charAt(word.length()-1);
        return (vowels.indexOf(firstLetter)<0)&&(vowels.indexOf(lastLetter)>=0);
    }
}
