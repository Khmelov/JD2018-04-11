package by.it.mokhart.jd01_06;

public class TaskB2 {

    private static void sort(String[] array) {
        int n = array.length;
        String t;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].length() > array[j].length()) {

                    t = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] sentences = Poem.text.split("(?<=[^.])[.!?]\\s+");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("\\p{Punct}", " ").trim()
                    .replaceAll("\\n", " ")
                    .replaceAll("\\s{2,}", " ");
        }
        sort(sentences);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}

