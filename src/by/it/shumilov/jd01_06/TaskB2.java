package by.it.shumilov.jd01_06;

import by.it.shumilov.jd01_06.Poem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        int dots = text.indexOf("..."); 
        text.replace(dots, dots+3, ",");
        String[] mas1  = text.toString().split("[.!?]{1}");
        Pattern pa = Pattern.compile("[\\p{Punct}\\p{Blank}\\n]+");
        Matcher ma ;
        String[] arr =new String[mas1.length];
        for (int i = 0; i < mas1.length; i++) {
            ma = pa.matcher(mas1[i]);
            String s1 = ma.replaceAll(" ");
            arr[i] = s1.trim();
        }
        boolean sort1 = false;
        boolean sort2 = false;
        String buf;
        int start = 0;
        int finish = arr.length - 1;



        do{
            for (int i = start; i < finish ; i++) {
                if(arr[i].length()> arr[i+1].length()) {
                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = buf;
                    sort1 = true;
                }
            }
            finish--;
            for (int i = finish; start < i; i--) {
                if(arr[i].length()< arr[i-1].length()) {
                    buf = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i-1] = buf;
                    sort2 = true;
                }

            }
            start++;

        }while ((start < finish) && (sort1 && sort2));

        for (String s : arr) {
            ma = pa.matcher(s);
            String s1 = ma.replaceAll(" ");
            System.out.println(s1.trim());
        }
    }
}
