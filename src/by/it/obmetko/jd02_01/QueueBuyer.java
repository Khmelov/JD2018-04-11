package by.it.obmetko.jd02_01;

import java.util.LinkedList;

public class QueueBuyer {
    private static LinkedList<Buyer> internalQueue = new LinkedList<>();

    static void addBuyer(Buyer buyer) {
        internalQueue.addLast(buyer);

    }
}