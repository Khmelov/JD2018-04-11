package by.it.shumilov.jd01_06;


import by.it.shumilov.jd01_06.Poem;

public class TaskB1 {
    private final static  String gl = "уеэоаыяиюёУЕЭОАЫЯИЮЁ";
    public static void main(String[] args) {
        String[] mas  = Poem.text.split("[^а-яА-ЯёЁ]+");
        for (String ma : mas) {
            if(check(ma)) System.out.println(ma);
        }

    }
    private static boolean check(String word){

        /* /еще вариант */
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);



        return  gl.indexOf(first)<0 && gl.indexOf(last)>=0;
    }
}
