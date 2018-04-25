package by.it.shumilov.jd01_06;

import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {

        long start1 = System.nanoTime();
        String s1 = slow(Poem.text);
        long time1 = System.nanoTime() - start1;
        System.out.println(s1);
        System.out.println(time1);

        long start2 = System.nanoTime();
        String s2 = fast(Poem.text);
        long time2= System.nanoTime() - start2;
        System.out.println(s2);
        System.out.println(time2);
    }
    private  static  String slow(String text){
        String[] words = text.split("[^а-яёА-ЯЁ]+");

        Random ram =new Random();

        String stout = words[0];
        ram.setSeed(12323);
        do{
            stout+= " " + words[ram.nextInt(words.length)];
        }
        while(stout.length()<101000);


        return stout;

    }
    private  static  String fast(String text){
        String[] words = text.split("[^а-яёА-ЯЁ]+");

        Random ram =new Random();
        ram.setSeed(12323);

        StringBuilder stout = new StringBuilder();
        //stout.setLength(105000);
        stout.append(words[0]);


        do{
            stout.append( " " + words[ram.nextInt(words.length)]);
        }
        while(stout.length()<101000);


        return stout.toString();

    }

}