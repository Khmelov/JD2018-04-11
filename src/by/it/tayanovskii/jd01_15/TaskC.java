package by.it.tayanovskii.jd01_15;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;


//Класс TaskC Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
//        использовать класс File и поддерживать две команды консоли:
//         команду cd - смена каталога (посмотрите пример: Win+R → cmd → cd \ → dir ). В тестах проверяются всего
//        две команды cd .. и cd имя_папки_в_текущем_каталоге
//         команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
//         команда end – завершение работы.
//         Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.


public class TaskC {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String path = dir(TaskC.class);
        String str;
        while (!(str = scanner.nextLine()).equals("end")) {
            if(str.equals("dir")) showDir(path);
            else if(str.indexOf("cd")>-1 && str.indexOf("..")==-1)
            {
                String newPath=path+File.separator+str.substring(3, str.length());
                path=newPath;
                System.out.println(path);
            }
            else if(str.indexOf("cd ..")>-1)
            {
                File newDir = new File(path);
                path=newDir.getParent();
                System.out.println(path);
            }
            else
                System.out.println("Неверная команда!");
            // System.out.println(str);
        }

    }

    private static String dir(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    private static void showDir(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                String name = "<DIR>";
                if (file.isFile())
                    name = String.valueOf(file.length());
                System.out.printf("%-20s %10s %-40s\n",
                        new Date(file.lastModified()), name, file.getName());
            }
        } else System.out.println("Неверная директория");
    }
}
