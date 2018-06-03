package by.it.tayanovskii.jd02_03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Backet {

    private static ConcurrentHashMap<String,Double> backet = new ConcurrentHashMap<>();
    private AtomicLong totalPrice = new AtomicLong(0);

    void putRandomGood (String good, Double price)
    {
        backet.put(good,price);
        totalPrice.addAndGet(price.longValue());
    }
    synchronized Double getTotalPrice()
    {
        return totalPrice.doubleValue();
    }

}
