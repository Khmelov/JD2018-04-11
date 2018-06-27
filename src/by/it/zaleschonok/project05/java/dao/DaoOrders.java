package by.it.zaleschonok.jd03_03.dao;

import by.it.zaleschonok.jd03_03.beans.Orders;

public class DaoOrders extends UniversalDAO<Orders> {
    public DaoOrders() {
        super(new Orders(), "orders");
    }
}
