package by.it.shumilov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.*;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws IOException {
        String line;
        Path path = Paths.get(path());

        DecimalFormat formatter=new DecimalFormat();
        DecimalFormatSymbols symbols=DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        SimpleDateFormat df=new SimpleDateFormat("EEE dd.MM.yy HH:mm");
        System.out.println( TaskC.class.getPackage().getName());

        Scanner sc=new Scanner(System.in);
        System.out.print(path+">");
        while (!(line = sc.nextLine()).equals("end")){
            if(line.length() > 0 )
            {
                String[] arggs = line.split(" ");
                if (arggs.length > 1){
                    if(arggs[0].equals("cd")){
                        if (arggs[1].equals("..")){

                            if (!path.equals(path.getRoot()))
                                path = path.getParent();
                        }
                        else if (Files.isDirectory(path.resolve(arggs[1])))
                            path = path.resolve(arggs[1]);
                    }

                }
                else if (arggs[0].equals("dir")){
                    System.out.println(df.format((new File(String.valueOf(path))).lastModified())
                            + ("      dir          ")+" .");
                    System.out.println(df.format((new File(String.valueOf(path))).lastModified())
                            + ("      dir          ")+" ..");


                    int dirs = 0;
                    int files = 0;
                    long sizeFiles = 0;

                    String[] lisStrim = Files.list(path)
                            .map((a)->df.format((new File(String.valueOf(a))).lastModified())
                                    + (!Files.isDirectory(a) ? (String.format("%19d", (new File(a.toString()).length()))) : ("      dir          "))
                                    +" " + a.getFileName().toString())
                            .toArray(String[]::new);
                    for (String s : lisStrim) {
                        System.out.println(s);
                    }

                    for (Path path1 : Files.newDirectoryStream(path)) {
                        if(Files.isDirectory(path1))
                            dirs++;
                        else {
                            files++;
                            sizeFiles +=Files.size(path1);
                        }
                    }
                    System.out.printf("%15d файл(ов) %13d байт\n", files,sizeFiles);
                    System.out.printf("%15d папок %16s байт свободно\n",
                                       dirs, formatter.format((new File(String.valueOf(path))).getFreeSpace()));




                }
                /*else
                    System.out.println();*/
            }
            //System.out.println();
            System.out.print(path+">");
        }
    }
    private  static  String path(){
        String[] a = TaskC.class.getPackage().getName().split("\\.");

        return  System.getProperty("user.dir") +File.separator+"src"+File.separator+String.join(File.separator,a) ;
    }
}