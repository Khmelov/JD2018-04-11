package by.it.rogov.jd02_05;



import javafx.scene.input.DataFormat;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm= ResMan.getInstance();
        System.out.println(Locale.getDefault());
        DataFormat dataFormat = new DataFormat();
        if (args.length==2){
            rm.setLocale(new Locale(args[0],args[1]));
        }

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (scanner.hasNext()) {
            System.out.println(1);
        }

        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
    }
}
