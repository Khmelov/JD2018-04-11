package projects.Home;

import java.util.*;

class Counting {
    static int maxPeople(int[][][] masTime) {
        LinkedList<Integer> outputsTime = new LinkedList<>();
        for (int[][] aMasTime : masTime) {
            int input = aMasTime[0][0];  // получение прихода первого сотрудника
            int output = aMasTime[1][0]; // время выхода сотрудника
            int inputMinuts = aMasTime[0][1];// получение минут
            int outputMinuts = aMasTime[1][1];
            int mInp = input * 60 + inputMinuts;// перевод в минуты
            int mOutp = output * 60 + outputMinuts;
            for (int i = mInp; i <= mOutp; i++) {
                outputsTime.addLast(i);
            }
        }
        Collections.sort(outputsTime);// сортировка
        HashMap<Integer, Integer> count = new HashMap<>();
        Integer i;
        for (Integer integer : outputsTime) {
            i = count.get(integer);
            count.put(integer, i == null ? 1 : i + 1);
        }
        int max = Collections.max(count.values());
        return max;
    }
}
