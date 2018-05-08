package by.it.tarasiuk.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String[] sentences=Poem.text.split("(?<![.])[.!?]\\s+");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i]=sentences[i].replaceAll("\\p{Punct}"," ").trim()
                    .replaceAll("\\p{Space}", " ")
                    .replaceAll("\\p{Space}{2,}", " ");
        }
        sortArray(sentences);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
    private static void sortArray(String[] array) {
        int i=1;
        while (i<array.length) {
            if (i==0||array[i-1].length()<=array[i].length())
                i++;
            else {
                String temp=array[i];
                array[i]=array[i-1];
                array[i-1]=temp;
                i--;
            }
        }
    }
}
