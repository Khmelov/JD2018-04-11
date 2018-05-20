package by.it.kurmaz.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        List<String> list = new ArrayList<>();

        System.out.println("Enter text");
        String text = "";
        String line;
        while (!(line = scanner.nextLine()).equals("end")) {
            text = text.concat(line);
        }
        String[] words = text.split("[^A-z']+");
        for (String word: words) {
            hashSet.add(word);
            list.add(word);
        }

        Iterator iter = hashSet.iterator();
        while (iter.hasNext()) {
            String word = (String) iter.next();
            int counter = Collections.frequency(list, word);
            System.out.println(word + "=" + counter);
        }

    }



}
