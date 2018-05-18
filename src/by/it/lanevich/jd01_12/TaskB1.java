package by.it.lanevich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {

    Scanner scan=new Scanner(System.in);
    String str;
    StringBuilder sb =new StringBuilder();
    List<String> wordAll=new ArrayList<>();
    Set<String> words=new HashSet<>();
    String[]word = {};
    Map<String,Integer> mapWord= new HashMap<>();
    while(!(str=scan.next()).equals("end")) {
        word = str.split("[.,!?:;—() ]+");
        for (int i = 0; i < word.length; i++) {
            word[i].trim();
            wordAll.add(word[i]);
            words.add(word[i]);
        }
        for (String w: words) {
            mapWord.put(w,Collections.frequency(wordAll,w));
        }
    }
        System.out.println(mapWord.toString());
    }




}
