package by.it.krivenkova.jd01_04;

public class TaskB {
    public static void main(String[] args) {
        int n = 3;
        String[] fam = {"Ivanov", "Petrov", "Sidorov"};
        int[][] z={
                {1,2,3,4},
                {11,22,33,44},
                {111,222,333,444}
        };
        System.out.println("-----------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4 Итого");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: ", fam[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += z[i][j];
                System.out.printf("%-10d", z[i][j]);
            }
            System.out.printf("%4d\n", sum);
        }
    }
}
