package by.it.dkruchek.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/19/2018.
 */
public class TaskC {
    private static Scanner sc;
    private static List<Double> nums = new ArrayList<>();

    private static void readData() throws InterruptedException {
        String s;
        int exceptionCounter = 0;
        while (!(s = sc.next()).equals("END")){
            try{
                nums.add(Double.parseDouble(s));
            }
            catch (NumberFormatException e){
                if (++exceptionCounter == 5) throw e;
                // sleep
                Thread.sleep(100);

                for (int i = nums.size() - 1 ; i >= 0; i--) {
                    System.out.print(nums.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }
}
