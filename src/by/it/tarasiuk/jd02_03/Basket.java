package by.it.tarasiuk.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Basket {
    private List<String> productsInBasket = new ArrayList<>();

    void addProduct(String productName) {
        productsInBasket.add(productName);
    }

    List<String> getProductsInBasket() {
        return productsInBasket;
    }
}
