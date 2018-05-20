package by.it.shumilov.jd01_13;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc;
    private  static int col = 0;

    public static void main(String[] args) throws Exception {

        sc =new Scanner(System.in);
        readData();

    }
    static void readData() throws Exception {

        List<Double> list = new LinkedList<>();
        String line;
        while (!(line = sc.next()).equals("END")){
            try{
                Double num = Double.parseDouble(line);

                list.add(num);

            }
            catch (Exception e){//////////////////
                if(col == 5)
                    //e.printStackTrace();
                    throw new Exception("123",e);


                    Thread.sleep(100);


                col++;
                List<Double> list1 = new LinkedList<>(list);
                while (list1.size() > 0){
                    System.out.print(((LinkedList<Double>) list1).removeLast()+ " ");
                }
                System.out.println();
            }
        }
    }
}
