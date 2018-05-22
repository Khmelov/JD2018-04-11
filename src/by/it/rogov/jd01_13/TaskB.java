package by.it.rogov.jd01_13;



import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Double sum=0.0,number,sqrts;


        while (!(s = scanner.next()).equals("END")) {
            try {

                number=(Double.parseDouble(s));
                sum+=number;

                if(sum<0) throw new ArithmeticException();

                sqrts=Math.sqrt(sum);

                System.out.printf("number: %s\n sqrt: %s\n ",number,sqrts );

            } catch (NumberFormatException | ArithmeticException e) {

                String name = e.getClass().getName();

                System.out.println("name: "+ name);

                StackTraceElement[] stackTrace = e.getStackTrace();

                for (StackTraceElement element : stackTrace) {

                    if (TaskB.class.getName().equals(element.getClassName())) {

                        System.out.println("class: " + element.getClassName() + "\n" + "line: " + element.getLineNumber());

                        break;
                    }
                }
            }

        }

    }
}
