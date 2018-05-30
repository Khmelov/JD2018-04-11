package by.it.tarasiuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Basket  {
    private List<String> products = new ArrayList<>();

    void add(String name) {
        products.add(name);
    }

    public List<String> getProducts() {
        return products;
    }



}
