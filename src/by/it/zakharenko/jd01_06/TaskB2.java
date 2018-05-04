package by.it.zakharenko.jd01_06;

public class TaskB2 {

    private static void bubbleSort(String[] arr) {
        int n = arr.length;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].length() > arr[j].length()) {

                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // split on sentences
        String[] sentences = Poem.text.split("(?<=[^.])[.!?]\\s+");
        //replace puntuation, new lines and extra spaces
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("\\p{Punct}", " ").trim()
                    .replaceAll("\\n", " ")
                    .replaceAll("\\s{2,}", " ");
        }
        // sort string array
        bubbleSort(sentences);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
