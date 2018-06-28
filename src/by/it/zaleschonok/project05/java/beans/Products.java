package by.it.zaleschonok.jd03_03.beans;

public class Products {

    private int id;
    private String product;
    private int price;

    public Products() {
    }

    public Products(int id, String product, int price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
