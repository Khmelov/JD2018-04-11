package by.it.rogov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class CashierEque {

    private CashierEque(){

    }
    private static Deque<Cashiers> eqeue = new LinkedList<>();

    static synchronized int sizeCashiersInEque(){
        return eqeue.size();
    }
    static synchronized void addCashier(Cashiers cashiers) {
        eqeue.addLast(cashiers);
    }

    static synchronized Cashiers extractCashierFromEqeue() {
        return eqeue.pollFirst();

    }
}
