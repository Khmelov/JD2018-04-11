package projects.Home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SPS {

    private static String str(Class<?> cls) {
        String name = cls.getName().replace(cls.getSimpleName(), "").replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        return path + name;
    }

    public static void main(String[] args) {
        //System.out.println(str(SPS.class));
        Pattern pattern = Pattern.compile("^(([0,1]?[0-9]|(2[0-3]))(:[0-5][0-9]))$");//паттерн для поиска времени (НН:ММ)
        try (BufferedReader br = new BufferedReader(
                new FileReader(str(SPS.class) + "input.txt")) // чтение файла
        ) {
            int[][][] ints = timeSearch(pattern, br); // проверка и сортировка времени
            int max = Counting.maxPeople(ints); //получение максимального количества сотрудников
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][][] timeSearch(Pattern pattern, BufferedReader br) throws IOException {
        int countStr = 0;
        LinkedList<String> list = new LinkedList<>();//все посетители
        while (br.ready()) {
            list.addLast(br.readLine());
            countStr++;
        }
        int[][][] masTime = new int[countStr][2][2];//количество посетителей(countStr), время прихода (НН:ММ) и время ухода (НН:ММ)
        int i = 0;
        int j = 0;
        int k = 0;
        boolean bool = false;
        for (String str : list) {
            String[] split = str.split(" "); //разделение на время прихода и выхода
            for (String s : split) {
                Matcher matcher = pattern.matcher(s);// проверка на соответсвие времени с патерном
                bool = false;
                while (matcher.find()) {
                    String[] split1 = matcher.group().split(":");// разделение на часы и минуты
                    bool = true;
                    for (String s1 : split1) {
                        masTime[i][j][k] = Integer.valueOf(s1);// преобразование строки в число и запись в массив
                        if (k < 1) k++;
                    }
                    if (j < 1) j++;
                    k = 0;
                }
            }
            j = 0;
            if (bool)
                i++;
        }
        return masTime;
    }
}
