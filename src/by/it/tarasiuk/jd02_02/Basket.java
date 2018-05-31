package by.it.tarasiuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Basket {
    private List<String> productsInBasket = new ArrayList<>();

    void addProduct(String productName) {
        productsInBasket.add(productName);
    }

    //может понадобиться для вывода чека
    public List<String> getProductsInBasket() {
        return productsInBasket;
    }
}
