package by.it.zaleschonok.jd03_03.beans;

public class Orders {

    private int id;
    private int amount;
    private int users_id;
    private int products_id;

    public Orders() {
    }

    public Orders(int id, int amount, int users_id, int goods_id) {
        this.id = id;
        this.amount = amount;
        this.users_id = users_id;
        this.products_id = goods_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getProducts_id() {
        return products_id;
    }

    public void setProducts_id(int goods_id) {
        this.products_id = goods_id;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", amount=" + amount +
                ", users_id=" + users_id +
                ", products_id=" + products_id +
                '}';
    }
}
