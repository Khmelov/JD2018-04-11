package by.it.lanevich.jd03_03.beans;

public class Order {
    long id;
    long ord_id;
    long numgood;
    long users_id;
    long goods_id;

    public Order(){
    }

    public Order(long id, long ord_id, long numgood, long users_id, long goods_id){
        this.id=id;
        this.ord_id=ord_id;
        this.numgood=numgood;
        this.users_id=users_id;
        this.goods_id=goods_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getOrd_id() { return ord_id; }

    public void setOrd_id(long ord_id) { this.ord_id = ord_id; }

    public long getNumgood() { return numgood; }

    public void setNumgood(long numgood) { this.numgood = numgood; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    public long getGoods_id() { return goods_id; }

    public void setGoods_id(long goods_id) { this.goods_id = goods_id; }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ord_id='" + ord_id + '\'' +
                ", numgood='" + numgood + '\'' +
                ", users_id='" + users_id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                '}';
    }

}
