package projects.Home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Counting {
    public static int maxPeople(int[][][] masTime) {
        int count = 1;
        ArrayList<Integer> peopleTogethe = new ArrayList<>();// запись одновременно находящихся людей
        LinkedList<String> outputsTime = new LinkedList<>();// время выхода персонала для проверки пересечения
        for (int q = 0; q < masTime.length; q++) {
            int input = masTime[q][0][0];  // получение прихода первого сотрудника
            int output = masTime[q][1][0]; // время выхода сотрудника
            for (int t = 0; t < masTime.length; t++) {
                if (t != q) {
                    int xInput = masTime[t][0][0];// время остальных сотрудников пришел
                    int xOutput = masTime[t][1][0];// вышел
                    if (output >= xInput) { // сравнение выхода первого и входа последующих
                        if (input <= xOutput) {
                            int inputMinuts = masTime[q][0][1];// получение минут
                            int outputMinuts = masTime[q][1][1];
                            int xInputMinuts = masTime[t][0][1];
                            int xOutputMinuts = masTime[t][1][1];
                            String yforSb=xOutput+":"+xOutputMinuts;
                            String forSb=xInput+":"+xInputMinuts;
                            outputsTime.addLast(yforSb);
                            if(outputsTime.contains(forSb)){
                                count--;
                            }
                            if (output == xInput) {
                                if (outputMinuts > xInputMinuts) {
                                    count++;
                                }
                            }else
                            if(input==xOutput){
                                if(inputMinuts<xOutputMinuts){
                                    count++;
                                }
                            }else if(input<xOutput){
                                count++;
                            }
                        }

                    }
                }
            }
            outputsTime.clear();
            peopleTogethe.add(count);
            count=1;
        }
        Collections.sort(peopleTogethe);
        int max=peopleTogethe.get(peopleTogethe.size()-1);
//        System.out.println(max);
    return max;
    }
}
