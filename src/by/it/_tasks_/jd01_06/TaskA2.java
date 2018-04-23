package by.it._tasks_.jd01_06;


import java.util.Arrays;


public class TaskA2 {
    public static void main(String[] args) {
        step1();


        /*Определить, сколько раз повторяется в тексте каждое слово, которое встречается в
нем, используя массивы. Вывести результаты на консоль в формате слово=повторы*/

    }

    private static void step1() {


        String[] mas  = Poem.text.split("[^а-яА-ЯёЁ]+");
        Arrays.sort(mas);
        int col = 1;
        String word = mas[0];



        for (int i = 1; i < mas.length; i++) {
            if(!word.equals(mas[i])) {

                System.out.println(word + "=" + col);
                word = mas[i];
                col=1;
            }
            else col++;
        }
        System.out.println(word + "=" + col);
    }


}
