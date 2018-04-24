package by.it.shumilov.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] cols = Poem.text.split("\n");
        int max = 0;
        for (String col : cols) {
            if(col.length() > max) max = col.length();
        }
        for (String col1 : cols) {
            System.out.println(plusGap(col1,max));
        }

    }

    /**
     * Функция добавления пробелов в строку
     * @param s Строка в которой необходимо добавить пробелы
     * @param max длина к которой необходимо преобразовать строку
     * @return Возврашает отформатированную строку
     *
     * */
    private  static String plusGap(String s,int max){
        String[] words = s.split(" ");
        int nAll = (max-s.length())/(words.length-1);
        int nOst  = (max-s.length())%(words.length-1);
        String stroka = words[0];

        String g = "";

        for (int i = 0; i < nAll; i++) {
            g+= " ";
        }


        for (int i = 1; i < nOst+1; i++) {
            stroka += "  " + g + words[i];
        }

        for (int i = nOst+1; i < words.length; i++) {
            stroka += " " + g + words[i];
        }


        return stroka;
    }
}