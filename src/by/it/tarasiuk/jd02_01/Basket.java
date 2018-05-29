package by.it.tarasiuk.jd02_01;

import java.util.ArrayList;

class Basket extends ArrayList<String> {
    private Basket buyerBasket=new Basket();

    public Basket getBuyerBasket() {
        return buyerBasket;
    }


}
