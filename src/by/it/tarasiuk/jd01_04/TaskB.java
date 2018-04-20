package by.it.tarasiuk.jd01_04;

//import java.util.Scanner;

public class TaskB {
    public static void main (String[] args) {
        int n=3;
        String[] fam = {"jjalfjsl", "dasds", "sad"};
        int[][] z = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {41414, 3131, 131, 133}
        };
        //out
        System.out.println("------------------------------------------------------");
        System.out.println("Фамиля     Квартал1  Квартал2  Квартал4        Итого");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s: ", fam[i]);
            int sum=0;
            for (int j = 0; j < 4; j++) {
                sum += z[i][j];
                System.out.printf("%-10d", z[i][j]);


            }
            System.out.printf("%-4d\n", sum);

        }

    }
//        Scanner scanner=new Scanner(System.in);
//        int n = scanner.nextInt();
//        String fam = scanner.nextLine();
}
