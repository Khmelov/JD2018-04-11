package by.it.lanevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String []predl= Poem.text.split("[.!?][\\n]");

        for (int i = 0; i < predl.length; i++) {
            predl[i]= predl[i].replaceAll("[^А-Яа-яЁё]+"," ");
            predl[i]=predl[i].trim();
        }

        int [] ras=new int[predl.length];
        for (int i = 0; i < predl.length; i++) {
            ras[i]=predl[i].length();
        }
        int [] ind=new int[ras.length];

        for (int i = 0; i < ind.length; i++) {
            ind[i]=i;
        }
        for (int i = 0; i <ras.length-1 ; i++) {
            for (int j = i+1; j < ras.length; j++) {
                if(ras[i]>ras[j])
                {int m=ras[i];
                    ras[i]=ras[j];
                    ras[j]=m;
                    int s=ind[i];
                    ind[i]=ind[j];
                    ind[j]=s;
                }
            }}


        for (int i = 0; i < ind.length; i++) {
            System.out.println(predl[ind[i]]);
        }
    }


}
//    Вывести через \n все предложения текста в порядке возрастания количества символов
//        (!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
//        последовательности на один пробел и выполнить trim() для каждого предложения.
//1. заменить все небуквенные символы и их последовательности на один пробел
//2. выполнить trim() для каждого предложения
//3. Вывести через \n все предложения текста в порядке возрастания количества символов (!) в каждом из них